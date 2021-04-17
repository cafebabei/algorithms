package com.test.signature;


import lombok.var;
import org.apache.commons.lang3.StringUtils;

import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class QueryParams {

    private TreeMap<String, String> map = new TreeMap<>();
    private String portalSignature;
    private String portalTimestamp;
    private String partnerCode;
    private Optional<String> partnerUserCode = Optional.empty();
    private Optional<String> bizSourceCode = Optional.empty();
    private Optional<String> appSourceCode = Optional.empty();

    static final String PORTAL_SIGNATURE = "portalSignature";
    static final String PORTAL_TIMESTAMP = "portalTimestamp";
    static final String PARTNER_CODE = "partnerCode";
    static final String PARTNER_USER_CODE = "partnerUserCode";
    static final String BIZ_SOURCE_CODE = "bizSourceCode";
    static final String APP_SOURCE_CODE = "appSourceCode";

    public static QueryParams of(String origin) {
        QueryParams params = new QueryParams();

        params.map = parseToQueryParams(origin);
        params.extractCoreParams();

        return params;
    }

    public static TreeMap<String, String> parseToQueryParams(String queryString) {
        var params = new TreeMap<String, String>();

        if (StringUtils.isEmpty(queryString)) {
            return params;
        }

        String[] splitQuestionMark = queryString.split("\\?");
        if (splitQuestionMark.length > 1) {
            queryString = splitQuestionMark[1];
        }

        for (var queryExp : queryString.split("&")) {
            int equalMarkIndex = queryExp.indexOf('=');

            String k = "";
            String v = "";

            if (equalMarkIndex > 0) {
                k = queryExp.substring(0, equalMarkIndex);
                v = queryExp.substring(equalMarkIndex + 1);
            }

            if (!StringUtils.isEmpty(k)) {
                v = decodeUrlParam(v);
                params.put(k, v);
            }
        }

        return params;
    }


    void extractCoreParams() {
        this.portalSignature = this.map.getOrDefault(PORTAL_SIGNATURE, "");
        this.portalTimestamp = this.map.getOrDefault(PORTAL_TIMESTAMP, "");
        this.partnerCode = this.map.getOrDefault(PARTNER_CODE, "");
        this.partnerUserCode = Optional.ofNullable(this.map.get(PARTNER_USER_CODE));
        this.bizSourceCode = Optional.ofNullable(this.map.get(BIZ_SOURCE_CODE));
        this.appSourceCode = Optional.ofNullable(this.map.get(APP_SOURCE_CODE));
    }

    boolean checkRequiredParams() {
        return !StringUtils.isEmpty(portalSignature)
            && !StringUtils.isEmpty(portalTimestamp)
            && !StringUtils.isEmpty(partnerCode);
    }

    public String prepareSignString() {
        return parseToQueryString(this.map, PORTAL_SIGNATURE);
    }


    public static String decodeUrlParam(String value) {
        if (null == value || value.isEmpty()) {
            return value;
        }

        try {
            value = URLDecoder.decode(value, "utf8");
        } catch (Throwable error) {
        }

        return value;
    }

    public static String parseToQueryString(Map<String, String> map, String... exclude) {
        return map.entrySet().stream()
            .filter(entry -> !Arrays.asList(exclude).contains(entry.getKey()))
            .map(entry ->
                String.format("%s=%s", entry.getKey(), entry.getValue()))
            .collect(Collectors.joining("&"));
    }
}