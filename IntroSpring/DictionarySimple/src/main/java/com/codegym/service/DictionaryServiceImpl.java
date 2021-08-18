package com.codegym.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService{
    @Override
    public String searchWord(String word) {
        String result = "";
        Map<String, String> dic = new HashMap<String, String>();
        dic.put("computer","máy tính");
        dic.put("smartphone","điện thoại thông minh");
        dic.put("book","sách");
        dic.put("pen","bút viết");

        if(dic.containsKey(word)) {
            result = dic.get(word);
        } else {
            result = "Từ nay hiện tại không có trong từ điển";
        }
        return result;
    }
}
