package com.test.other.signature;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * @author cheney
 * @version 2020/6/9 5:18 下午
 * @since jdk_1.8.0_201
 */
public class SignatureGen {

    public static void main(String[] args) throws IOException { //
        String partnerSecret = System.getenv().get("XR_PARTNER_SECRET_" + StringUtils.upperCase(
            Arrays.stream(args[0].split(",")).filter(s -> "env".equalsIgnoreCase(s.split("=")[0]))
                .findFirst().map(s -> s.split("=")[1]).orElse("test")));
        String aesUserCode = AESUtil.encrypt(System.getenv().get("XR_AES_KEY"),
            Arrays.stream(args[0].split(",")).filter(s -> "userCode".equalsIgnoreCase(s.split("=")[0])).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("userCode")), System.getenv().get("XR_AES_IV"));
        String encodedAesUserCode = URLEncoder.encode(aesUserCode, "UTF-8");
        String urlString = com.test.other.signature.QueryParams.of("recommendId=TJDXR20170704114456DWQUN"
            + "&portalTimestamp=1586861782786&partnerCode=1001&partnerUserCode=" + encodedAesUserCode + "&bizSourceCode"
            + "=biz_online_axamedicalconcierge&appSourceCode=app_2b_wminiprogram&project=axa&subProject=mc&memberId=30")
            .prepareSignString();
        String signature = Hex.encodeHexString(AESUtil.encryptHmacSHA256(partnerSecret.getBytes(),
            urlString.getBytes()));
        urlString = urlString.replace(aesUserCode, encodedAesUserCode);
        System.out.println("portalSignature=" + signature + "&" + urlString);
    }
}




