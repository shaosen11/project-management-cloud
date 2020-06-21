package com.edu.lingnan.controller;

import com.edu.lingnan.entity.*;
import com.edu.lingnan.exception.AJaxResponse;
import com.edu.lingnan.feign.*;
import com.edu.lingnan.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 10:25 2020/6/21
 */
@Controller
public class DocumentRecordController {
    /**
     * 服务对象
     */
    @Autowired
    private DocumentFeignService documentFeignService;

    @Autowired
    private ProjectFeignService projectFeignService;

    @Autowired
    private ProjectUserFeignService projectUserFeignService;

    @Autowired
    private ProjectCodeLineFeignService projectCodeLineFeignService;

    @Autowired
    private SysUserFeignService sysUserFeignService;

    @Autowired
    private ProjectPackageFeignService projectPackageFeignService;

    @Autowired
    private ProjectMessageFeignService projectMessageFeignService;

    @Autowired
    private ProjectMessageNeedToDoRelationshipFeignService projectMessageNeedToDoRelationshipFeignService;

    @Autowired
    private DocumentRecordFeignService documentRecordFeignService;

    @GetMapping("/documentRecordPage")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> pages(Integer page, Integer projectId, Integer userId) {
        System.out.println("当前页：" + page);
        System.out.println("当前项目：" + projectId);
        System.out.println("用户:" + userId);
        Map<String, Object> map = new HashMap<String, Object>();
        // 每页显示条数
        int pageSize = 5;

        try {
            // 获取总条目数
            Integer count = null;
            if (userId == 0) {
                count = documentRecordFeignService.getDocumentRecordCountByProjectId(projectId);
            } else {
                count = documentRecordFeignService.getDocumentRecordCountByProjectIdAndUserId(projectId, userId);
            }
            // 计算总页数
            int totalPage = count / pageSize;
            // 不满一页的数据按一页计算
            if (count % pageSize != 0) {
                totalPage++;
            }
            // 当页数大于总页数，直接返回
            if (page > totalPage) {
                return null;
            }
            // 计算sql需要的起始索引
            int offset = (page - 1) * pageSize;
            // 根据起始索引和页面大小去查询数据
            List<DocumentRecord> list = null;
            if (userId == 0) {
                list = documentRecordFeignService.getDocumentRecordPageByProjectId(projectId, offset, pageSize);
            } else {
                list = documentRecordFeignService.getDocumentRecordPageByProjectIdAndUserId(projectId, userId, offset, pageSize);
            }
            // 封装数据，并返回
            map.put("page", page);
            map.put("pageSize", pageSize);
            map.put("totalPage", totalPage);
            map.put("list", list);

            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("获取分页数据失败" + e);
            return new ResponseEntity<Map<String, Object>>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/document/{projectId}/{documentName}")
    public String text(
            @PathVariable("documentName") String documentName,
            @PathVariable("projectId") Integer projectId,
            Model model, HttpServletRequest request) {
        //获取文件名为filename和版本标识符为1的
        Document document1 = documentFeignService.getByProjectIdAndVersionFlagAndName(projectId, 1, documentName);
        //获取文件名为filename和版本标识符为2的
        Document document2 = documentFeignService.getByProjectIdAndVersionFlagAndName(projectId, 2, documentName);
        //判断有无VersionFlag为2的
        if (document2 == null) {
            //只有版本号为1的，把d1赋值给d1
            Document document = document1;
            //返回前端document对象
            model.addAttribute("document1", document);
            model.addAttribute("addressd2", null);
            //处理文件，返回前端地址
            String addressDocument = FileUtil.DocumentGetAddrress(document);
            //返回前端地址
            model.addAttribute("addressdocument", addressDocument);
        } else {
            //返回前端document对象
            model.addAttribute("document1", document1);
            model.addAttribute("document2", document2);
            //处理文件，返回前端地址
            String addressd1 = FileUtil.DocumentGetAddrress(document1);
            String addressd2 = FileUtil.DocumentGetAddrress(document2);
            //返回前端地址
            model.addAttribute("addressd1", addressd1);
            model.addAttribute("addressd2", addressd2);
        }
        //设置项目id
        model.addAttribute("projectId", projectId);
        //判断是否为项目组长
        Integer projectAdmin = null;
        MyUserDetails myUserDetails = UserUtil.getMyUserDetailsBySecurity(request);
        if (myUserDetails != null) {
            if (projectFeignService.getAdminByUserIdAndProjectId(myUserDetails.getId(), projectId) != null) {
                projectAdmin = 1;
            }
        }
        model.addAttribute("projectAdmin", projectAdmin);
        Project project = projectFeignService.getById(projectId);
        model.addAttribute("project", project);
        return "project/documentview";
    }

    @PostMapping("/document")
    public String uploadFile(MultipartFile[] files, Integer projectId, Document document, String packageName, HttpServletRequest request) throws Exception {
        MyUserDetails myUserDetails = UserUtil.getMyUserDetailsBySecurity(request);
        System.out.println("项目id：" + projectId);
        System.out.println("packageName:::" + packageName);
        if (files.length == 0) {
            return "failure";
        }
        for (MultipartFile file : files) {
            //生成随机号
            String uuid = UUID.randomUUID().toString();
            uuid = uuid.replace("-", "");
            //获取文件名
            String oldFileName = file.getOriginalFilename();
            int index = oldFileName.lastIndexOf("\\");
            if (index != -1) {
                oldFileName.substring(index + 1);
            }
            //拼接文件名，防止冲突
            String newFileName = uuid + "-" + oldFileName;
            //设置Document的属性
            document.setName(oldFileName);
            document.setSerialNumber(uuid);
            //以后需要修改projiectId
            document.setProjectId(projectId);
            document.setUserId(myUserDetails.getId());
            document.setUploadTime(new Date());
            //装换文件类型，且读取代码行数
            Integer codeline = FileUtil.codeLine(FileUtil.multipartFileToFile(file));
            if (codeline != 0) {
                document.setCodeLineNumber(codeline);
            } else {
                document.setCodeLineNumber(0);
            }
            System.out.println("转换结束");
            //控制上传确定版本号为2的
            if (documentFeignService.getByProjectIdAndVersionFlagAndName(document.getProjectId(), 2, oldFileName) != null) {
                String msg = "存在未审核版本，不能上传，请通知项目组长审核";
                System.out.println(msg);
                return "false";
            }
            //查询版本号
            Integer version = documentFeignService.getVersionByProjectIdAndName(document.getProjectId(), oldFileName);
            //新文件标志
            Integer newDocumentFlag = 0;
            if (version != null) {
                document.setVersion(version + 1);
                document.setVersionFlag(2);
            } else {
                newDocumentFlag = 1;
                document.setVersion(1);
                document.setVersionFlag(1);
                //第一次插入统计代码行
                //修改代码贡献量
                Integer codeLine = document.getCodeLineNumber();
                updateProjectUser(codeLine, document.getUserId(), document.getProjectId());
                //插入ProjectCodeLine表
                insertProjectCodeLine(document.getProjectId());
            }
            System.out.println(document);
            //插入数据库
            documentFeignService.insert(document);
            //插入日志文件
            //获取ip
            String ip = IPUtil.getIpAddress(request);
            insertDocumentRecord(document, ip, 1);
            //插入文件包表数据库
            insertPackage(document, packageName);
            //修改项目上传次数
            Project project = projectFeignService.getById(projectId);
            System.out.println(project);
            Integer projectCodeUpdateCount = project.getCodeUpdateCount();
            if (projectCodeUpdateCount == null) {
                project.setCodeUpdateCount(1);
            } else {
                project.setCodeUpdateCount(projectCodeUpdateCount + 1);
            }
            //修改文件数量
            if (newDocumentFlag == 1) {
                project.setDocumentCount(project.getDocumentCount() + 1);
            }
            project.setLastUpdateTime(new Date());
            projectFeignService.updete(project);
            //插入项目消息
            insertDocumentUpdateProjectMessage(document);
            //写入服务器
            System.out.println("上传文件");
            //调用自定义的FTP工具类上传文件
            String fileName = FtpUtil.uploadFile(file, newFileName, document.getProjectId());
            if (!StringUtils.isEmpty(fileName)) {
                System.out.println("上传文件" + fileName);
            }
        }
        if (document.getVersionFlag() == 2) {
            //获取文件名为filename和版本标识符为1的
            Document d1 = documentFeignService.getByProjectIdAndVersionFlagAndName(document.getProjectId(), 1, document.getName());
            System.out.println(d1);
            //获取文件名为filename和版本标识符为2的
            Document d2 = documentFeignService.getByProjectIdAndVersionFlagAndName(document.getProjectId(), 2, document.getName());
            System.out.println(d2);
        }
        return "forword:document/" + projectId + "/" + document.getName();
    }

    //修改文件状态
    //-1表示以前没有用过的版本
    //0表示以前通过版本
    //1表示当前版本
    //2表示要审核版本
    @PutMapping("/document")
    public String updateFileState(Integer projectId, String documentName, Integer userId, Integer operate, HttpServletRequest request) {
        //Integer operate表示操作的类型，
        // 1表示同意，把d1的versionFing改为0，d2的改为1
        // 2表示不同意，把d2的改为0
        //获取文件名为filename和版本标识符为1的
        Document d1 = documentFeignService.getByProjectIdAndVersionFlagAndName(projectId, 1, documentName);
        //获取文件名为filename和版本标识符为2的
        Document d2 = documentFeignService.getByProjectIdAndVersionFlagAndName(projectId, 2, documentName);
        ProjectMessageNeedToDoRelationship relationship = projectMessageNeedToDoRelationshipFeignService.getByDocumentId(d2.getId());
        if (operate == 1) {
            agreeNeedToDo(relationship.getProjectMessageId(), userId, request);
        } else {
            doNotagreeProjectMessageToDo(relationship.getProjectMessageId(), userId, request);
        }
        return "forword:document/" + projectId + "/" + d2.getName();
    }

    @RequestMapping("/updatedocument")
    public String updatedocument(
            @RequestParam("projectId") Integer projectId,
            @RequestParam("filename") String filename,
            @RequestParam("packageName") String packageName,
            @RequestParam("versionMessage") String versionMessage,
            @RequestParam("creator") Integer creator, Model model) {
        //查找document
        Document document = documentFeignService.getByProjectIdAndVersionFlagAndName(projectId, 1, filename);
        //修改版本信息
        if (versionMessage != null || versionMessage.length() > 0) {
            document.setVersionMessage(versionMessage);
        }
        //修改包
        if (packageName != null || packageName.length() > 0) {
            System.out.println("修改包名：：" + updateprojectPackage(document, packageName));
        }
        model.addAttribute("projectId", document.getProjectId());
        model.addAttribute("filename", document.getName());
        model.addAttribute("userId", creator);
        return "forword:document/" + projectId + "/" + document.getName();
    }

    @GetMapping("/download")
    @ResponseBody
    public String download(Integer projectId, String documentName) {
        Document document = documentFeignService.getByProjectIdAndVersionFlagAndName(projectId, 1, documentName);
        String downloadPath = "http://www.projectmanagment.top" + FileUtil.DocumentGetAddrress(document);
        System.out.println(downloadPath);
        return downloadPath;
//        File file = new File(downloadPath);
//        if (file.exists()) {
//            System.out.println("文件存在");
//            response.setHeader("content-type", "application/octet-stream");
//            response.setContentType("application/octet-stream");
//            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
//            byte[] buffer = new byte[1024];
//            FileInputStream fis = null;
//            BufferedInputStream bis = null;
//            try {
//                fis = new FileInputStream(file);
//                bis = new BufferedInputStream(fis);
//                OutputStream os = response.getOutputStream();
//                int i = bis.read(buffer);
//                while (i != -1) {
//                    os.write(buffer, 0, i);
//                    i = bis.read(buffer);
//                }
//                return AJaxResponse.success("下载成功!");
//            } catch (Exception e) {
//                e.printStackTrace();
//                return AJaxResponse.error("抛出错误!");
//            } finally {
//                {
//                    try {
//                        bis.close();
//                        fis.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        }else {
//            return AJaxResponse.error("文件不存在!");
//        }
    }

    /**
     * 如果codeLine大于0，代码增加,等于0，代码不变，上传次数增加
     * @param codeLine
     * @param userId
     * @param projectId
     */
    public void updateProjectUser(Integer codeLine, Integer userId, Integer projectId) {
        //获得人员项目表中的
        ProjectUser projectUser = projectUserFeignService.getByUserIdAndProjectId(userId, projectId);
        Project project = projectFeignService.getById(projectId);
        //修改个人代码贡献量
        if (codeLine > 0) {
            projectUser.setCodeDevoteLine(projectUser.getCodeDevoteLine() + codeLine);
        }
        //修改代码上传次数
        Integer codeUpdate = projectUser.getCodeUpdate();
        if (codeUpdate == null) {
            projectUser.setCodeUpdate(1);
        } else {
            projectUser.setCodeUpdate(codeUpdate + 1);
        }
        projectUserFeignService.update(projectUser);
        //修改系统代码量
        project.setCodeLineNumber(project.getCodeLineNumber() + codeLine);
        projectFeignService.updete(project);
        return;
    }

    public boolean insertProjectCodeLine(Integer projectId) {
        ProjectCodeLine projectCodeLine = projectCodeLineFeignService.getProjectCodeLineByProjectIdAndToday(projectId);
        //判断今天有没有记录
        if (projectCodeLine != null) {
            //有记录，修改记录
            projectCodeLine.setCodeLineNumber(projectFeignService.getById(projectId).getCodeLineNumber());
            return projectCodeLineFeignService.update(projectCodeLine);
        } else {
            //新建对象
            ProjectCodeLine projectCodeLine1 = new ProjectCodeLine();
            projectCodeLine1.setProjectId(projectId);
            projectCodeLine1.setCodeLineNumber(projectFeignService.getById(projectId).getCodeLineNumber());
            return projectCodeLineFeignService.insert(projectCodeLine1);
        }
    }

    //1是上传了文件，等待审核
    //2是审核文件通过了
    //3是审核文件不通过
    //通过document插入日志表
    public boolean insertDocumentRecord(Document document, String ip, Integer operateType) {
        //为了让日志文件时间和插入数据库时间一样
        document = documentFeignService.getByProjectIdAndVersionAndName(document.getProjectId(), document.getVersion(), document.getName());
        DocumentRecord documentRecord = new DocumentRecord();
        documentRecord.setProjectId(document.getProjectId());
        documentRecord.setUserId(document.getUserId());
        documentRecord.setOperateTime(document.getUploadTime());
        documentRecord.setIp(ip);
        //处理操作
        SysUser sysUser = sysUserFeignService.queryById(document.getUserId());
        //判断操作类型
        String operateMassage = null;
        if (operateType == 1) {
            operateMassage = sysUser.getUsername() + "上传了" + document.getName() + "，版本号为：" + document.getVersion();
        } else if (operateType == 2) {
            operateMassage = sysUser.getUsername() + "同意了第" + document.getVersion() + "版本" + document.getName() + "文件上传";
        } else if (operateType == 3) {
            operateMassage = sysUser.getUsername() + "不同意第" + document.getVersion() + "版本" + document.getName() + "文件上传";
        }
        System.out.println(operateMassage);
        documentRecord.setOperateMessage(operateMassage);
        System.out.println(documentRecord);
        return documentRecordFeignService.insert(documentRecord);
    }

    //插文件进入文件包表
    public boolean insertPackage(Document document, String packageName) {
        //先查找文件在文件包表是否存在
        if (projectPackageFeignService.getDocumentsNameByProjectIdAndPackageNameAndDocumentsName(document.getProjectId(), packageName, document.getName()) != null) {
            System.out.println("文件已存在，不用再插入文件包表");
            return false;
        } else {
            ProjectPackage projectPackage = new ProjectPackage();
            //设置项目id
            projectPackage.setProjectId(document.getProjectId());
            //设置包名
            projectPackage.setPackageName(packageName);
            //设置文件名
            projectPackage.setDocumentName(document.getName());
            //设置创造者
            projectPackage.setUserId(document.getUserId());
            //设置时间
            projectPackage.setCreateTime(new Date());
            //查找包Id
            int packageId = projectPackageFeignService.getPackageByProjectIdAndPackageName(document.getProjectId(), packageName).getPackageId();
            System.out.println("packageId:::" + packageId);
            //设置包id
            projectPackage.setPackageId(packageId);
            return projectPackageFeignService.insert(projectPackage);
        }
    }

    public void insertDocumentUpdateProjectMessage(Document document) {
        //封装项目消息
        ProjectMessage projectMessage = new ProjectMessage();
        projectMessage.setProjectId(document.getProjectId());
        projectMessage.setTypeId(1);
        projectMessage.setTime(DateFromatUtil.getNowDate(new Date()));
        projectMessage.setFromUserId(document.getUserId());
        SysUser sysUser = sysUserFeignService.queryById(document.getUserId());
        String msg = null;
        if (document.getVersionFlag() == 1) {
            //不需要审核
            projectMessage.setAllFlag(1);
            msg = sysUser.getUsername() + "上传了第" + document.getVersion() + "版本的" + document.getName() + "。";
            //获取上传者信息
            projectMessage.setMessage(msg);
            projectMessageFeignService.insert(projectMessage);
        } else {
            //需要审核
            projectMessage.setAdminFlag(1);
            projectMessage.setNeedToDo(1);
            msg = sysUser.getUsername() + "上传了第" + document.getVersion() + "版本的" + document.getName() + ",请尽快审核。";
            //获取上传者信息
            projectMessage.setMessage(msg);
            projectMessageFeignService.insert(projectMessage);
            //建立消息待办联系
            System.out.println(projectMessage.getId());
            System.out.println(document.getId());
            ProjectMessageNeedToDoRelationship projectMessageNeedToDoRelationship = new ProjectMessageNeedToDoRelationship();
            projectMessageNeedToDoRelationship.setProjectMessageId(projectMessage.getId());
            projectMessageNeedToDoRelationship.setDocumentId(document.getId());
            projectMessageNeedToDoRelationshipFeignService.insert(projectMessageNeedToDoRelationship);
        }
    }

    public AJaxResponse agreeNeedToDo(Integer projectMessageId, Integer userId, HttpServletRequest request) {
        //通过消息id找到关系表
        ProjectMessageNeedToDoRelationship projectMessageNeedToDoRelationship = projectMessageNeedToDoRelationshipFeignService.getByProjectMessageId(projectMessageId);
        //如果是文件审核消息
        if (projectMessageNeedToDoRelationship.getDocumentId() != 0) {
            //版本号为2的文件,修改文件versionFlag值为2的变为1
            Document document2 = documentFeignService.getById(projectMessageNeedToDoRelationship.getDocumentId());
            System.out.println(document2);
            //版本号为1的文件,修改文件versionFlag值为1的变为0
            Document document1 = documentFeignService.getByProjectIdAndVersionFlagAndName(document2.getProjectId(), 1, document2.getName());
            document1.setVersionFlag(0);
            documentFeignService.update(document1);
            document2.setVersionFlag(1);
            documentFeignService.update(document2);
            //获取ip
            String ip = IPUtil.getIpAddress(request);
            //修改代码贡献量
            Integer codeLine = document2.getCodeLineNumber() - document1.getCodeLineNumber();
            updateProjectUser(codeLine, document2.getUserId(), document2.getProjectId());
            //插入projectcodeline表
            insertProjectCodeLine(document1.getProjectId());
            //插入日志表
            insertDocumentRecord(document2, ip, 2);
            //项目消息处理
            ProjectMessage projectMessage = new ProjectMessage();
            projectMessage.setProjectId(document1.getProjectId());
            projectMessage.setFromUserId(document2.getUserId());
            projectMessage.setTypeId(3);
            projectMessage.setTime(DateFromatUtil.getNowDate(new Date()));
            projectMessage.setAllFlag(1);
            //获取上传人信息
            MyUserDetails commitUser = sysUserFeignService.getSimpleMyUserDetailsByUserId(document2.getUserId());
            String msg = commitUser.getUsername() + "上传了" + document2.getVersion() + "版本的" + document2.getName();
            projectMessage.setMessage(msg);
            projectMessageFeignService.insert(projectMessage);
            //处理个人消息
            projectMessage.setFromUserId(userId);
            projectMessage.setToUserId(document2.getUserId());
            projectMessage.setAllFlag(0);
            //获取同意人信息
            ProjectUser projectUser = projectUserFeignService.getByUserIdAndProjectId(userId, document2.getProjectId());
            msg = projectUser.getProjectUserDuty().getDutyName() + projectUser.getMyUserDetails().getUsername() +
                    "同意了你第" + document2.getVersion() + "版本" + document2.getName() + "的上传";
            projectMessage.setMessage(msg);
            projectMessageFeignService.insert(projectMessage);
            //设置消息已处理
            ProjectMessage projectMessage1 = projectMessageFeignService.getById(projectMessageId);
            projectMessage1.setIsRead(0);
            projectMessageFeignService.update(projectMessage1);
            Project project = projectFeignService.getById(document2.getUserId());
            project.setLastUpdateTime(new Date());
            projectFeignService.updete(project);
            return AJaxResponse.success("处理完成");
        }
        return null;
    }


    //修改文件包信息
    public boolean updateprojectPackage(Document document, String packageName) {
        System.out.println("document:::" + document);
        System.out.println("packageName" + packageName);
        //先查找出原先记录
        ProjectPackage projectPackage = projectPackageFeignService.getDocumentNameByProjectIdAndDocumentName(document.getProjectId(), document.getName());
        //先查看包名是否存在
        if (projectPackageFeignService.getPackageByProjectIdAndPackageName(document.getProjectId(), packageName) == null) {
            System.out.println("包不存在，不要在插入文件包表");
            return false;
        } else {
            //先查找这条记录
            //查找包id
            ProjectPackage projectPackage1 = projectPackageFeignService.getPackageByProjectIdAndPackageName(document.getProjectId(), packageName);
            System.out.println("document::" + projectPackage1.getPackageId() + "________________________________________");
            Integer packageId = projectPackage1.getPackageId();
            System.out.println(packageId);
            projectPackage.setPackageId(packageId);
            projectPackage.setPackageName(packageName);
            return projectPackageFeignService.update(projectPackage);
        }
    }

    public AJaxResponse doNotagreeProjectMessageToDo(Integer projectMessageId, Integer userId, HttpServletRequest request){
        //通过消息id找到关系表
        ProjectMessageNeedToDoRelationship projectMessageNeedToDoRelationship = projectMessageNeedToDoRelationshipFeignService.getByProjectMessageId(projectMessageId);
        //如果是文件审核消息
        if (projectMessageNeedToDoRelationship.getDocumentId() != 0) {
            Document document2 = documentFeignService.getById(projectMessageNeedToDoRelationship.getDocumentId());
            //不同意修改文件，只修改文件versionFlag值2的变为-1
            document2.setVersionFlag(-1);
            documentFeignService.update(document2);
            //获取ip
            String ip = IPUtil.getIpAddress(request);
            insertDocumentRecord(document2, ip, 2);
            //项目消息处理
            ProjectMessage projectMessage = new ProjectMessage();
            projectMessage.setProjectId(document2.getProjectId());
            projectMessage.setFromUserId(userId);
            projectMessage.setToUserId(document2.getUserId());
            projectMessage.setTypeId(4);
            projectMessage.setTime(DateFromatUtil.getNowDate(new Date()));
            //获取拒绝人信息
            ProjectUser projectUser = projectUserFeignService.getByUserIdAndProjectId(userId, document2.getProjectId());
            String msg = projectUser.getProjectUserDuty().getDutyName() + projectUser.getMyUserDetails().getUsername() +
                    "拒绝了你第" + document2.getVersion() + "版本" + document2.getName() + "的上传";
            projectMessage.setMessage(msg);
            projectMessageFeignService.insert(projectMessage);
            //设置消息已处理
            projectMessage = projectMessageFeignService.getById(projectMessageId);
            projectMessage.setIsRead(0);
            projectMessageFeignService.update(projectMessage);
            Project project = projectFeignService.getById(document2.getProjectId());
            project.setLastUpdateTime(new Date());
            projectFeignService.updete(project);
            return AJaxResponse.success("处理完成");
        }
        return null;
    }
}
