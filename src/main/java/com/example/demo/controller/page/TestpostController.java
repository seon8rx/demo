package com.example.demo.controller.page;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;

@RequestMapping("/testpost")
@Controller
public class TestpostController {

    @GetMapping("/{page}")
    public String page(@PathVariable String page) {
        return "testpost/" + page;
    }

    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id) {
        return "testpost/" + page;
    }

    @ResponseBody
    @RequestMapping(value = "/download/{file_name:.+}", method = RequestMethod.GET)
    public void download(@PathVariable("file_name") String file_name, HttpServletResponse response) throws IOException {
        String root_path = "/Users/seooonggyu/Documents/testpostFileUpload/";
        File file = new File(root_path + file_name);

        String mimeType = URLConnection.guessContentTypeFromName(file_name);
        if(mimeType==null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(file.getName(), "utf-8") +"\"");

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

}
