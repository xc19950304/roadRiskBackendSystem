package com.example.demo;


import com.github.qcloudsms.*;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;

public class SMSVerification {
    // 短信应用SDK AppID
    static final int appid = 1400155004; // 1400开头
    // 短信应用SDK AppKey
    static final String appkey = "2aa1a99095697b7b7ab8808975c69466";
    // 需要发送短信的手机号码
    static final String[] phoneNumbers = {"18674048294"};
    // 短信模板ID，需要在短信应用中申请
    static final int templateId = 7839; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
    //templateId7839对应的内容是"您的验证码是: {1}"
// 签名
    static final String smsSign = "腾讯云"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
    public static void sendMessage() {
        try {
            String[] params = {"5678"};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
            sendMessage();
    }
}
