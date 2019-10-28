package com.example.test.upload;

import com.example.test.common.MyRsp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequestMapping(value = "upload",method = RequestMethod.POST)
@Controller
public class UploadController {

    @Value("${app.imgPath}")
    public String imgPath;

    @PostMapping("/addImage")
    @ResponseBody
    public Object addImg(@RequestParam(name = "img", required = false) MultipartFile file) {
        File file1 = new File(imgPath+file.getOriginalFilename());
        try {
            if (!file.isEmpty()) {
                file.transferTo(file1);
            } else {
               return MyRsp.error().msg("图片上传为空");
            }
        } catch (IOException e) {
            return MyRsp.error().msg("图片上传失败");
        }
        return MyRsp.success(file.getOriginalFilename()).msg("上传成功");
    }

}
