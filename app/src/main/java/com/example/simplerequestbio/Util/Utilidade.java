package com.example.simplerequestbio.Util;

public class Utilidade {
    public static final Boolean useHttp = false;
    public static final String http = useHttp ? "https://": "http://";
    public static final String ip = "10.0.0.6:8005";
    public static final String HOST_SERVER = http + ip;
    public static final String validaBiometria = "/index.php?r=pratico/syncServerMT/ValidaBiometria";

}
