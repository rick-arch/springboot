package com.example.springboot.constant;

public final class Constant {

    public static final Integer NUM_ZERO = 0;
    public static final Integer NUM_ONE = 1;
    public static final Integer NUM_TWO = 2;
    public static final Integer NUM_THREE = 3;
    public static final Integer NUM_FOUR = 4;
    public static final Integer NUM_FIVE = 5;
    public static final Integer NUM_SIX = 6;
    public static final Integer NUM_SEVEN = 7;
    public static final Integer NUM_EIGHT = 8;
    public static final Integer NUM_NINE = 9;
    public static final Integer NUM_TEN = 10;
    public static final Integer NUM_SIXTY = 16;
    public static final Integer NUM_ONE_HUNDRED_TWENTY = 120;
    public static final Integer NUM_TWO_HUNDRED = 200;
    public static final Integer NUM_FOUR_HUNDRED_THREE = 403;
    public static final Integer NUM_FOUR_HUNDRED_FOUR = 404;
    public static final Integer NUM_FIVE_HUNDRED = 500;
    public static final Integer NUM_TWO_HUNDRED_FIFTY_NINE_TWO_THOUSAND = 2592000;
    public static final Long LONG1L = 1L;
    public static final Long LONG0L = 0L;


    public static final String CODE = "code";
    public static final String MSG = "msg";
    public static final String MSG_SUCCESS = "操作成功";
    public static final String MSG_FAIL = "操作失败";
    public static final String ERROR_STACK = "异常栈:";
    public static final String KICK_OUT_USER_FAILED = "踢出用户失败";
    public static final String AUTHENTICATION_FAILED = "Authentication Failed！";
    public static final String NO_SUCH_ALGORITHM_EXCEPTION = "No Such Algorithm Exception！";
    public static final String SESSION_TIME_OUT = "Session Time Out！";
    public static final String USER = "user";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String FALSE = "false";
    public static final String ON_LINE = "在线";
    public static final String NOT_ON_LINE = "离线";
    public static final String MD5 = "MD5";
    public static final String SUPPRESS_WARNINGS_ALL = "all";
    public static final String SERVER_PORT = "${server.port}";
    public static final String PROJECT_URL = "http://%s:%s";
    public static final String SLASH = "/";
    public static final String PROJECT_NOTIFICATION_INFO = "项目启动地址：";
    public static String CHROME_PATH = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe ";
    public static final String SESSION_PRINCIPAL_KEY = "SESSION_PRINCIPAL_KEY";
    public static final String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";
    public static final String X_REQUESTED_WITH = "x-requested-with";
    public static final String XML_HTTP_REQUEST = "XMLHttpRequest";
    public static final String SYS_USER_SERVICE_IMPL = "sysUserServiceImpl";
    public static final String USER_AGENT = "user-agent";
    public static final String REDIS_ACCESS_URL = "Access try count is {} for name={} and key = {}";
    public static final String REDIS_BLACK_LIST = "You have been dragged into the blacklist";
    public static final String SERVER_EXCEPTION = "server exception";
    public static final String X_FORWARDED_FOR = "x-forwarded-for";
    public static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    public static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    public static final String AND_SYMBOL = "&";
    public static final String LAYUI_ICON = "layui-icon ";
    public static final String AMP = "&amp";
    public static final String UNKNOWN = "unknown";

    /**
     * swagger配置相关
     */
    public static final String SWAGGER_BASE_PACKAGE = "com.example.springboot.controller";
    public static final String SWAGGER_TITLE = "This System Interface Address";
    public static final String SWAGGER_NAME = "SpringBoot";
    public static final String SWAGGER_URL = "http://localhost:" + SERVER_PORT + "/login";
    public static final String SWAGGER_EMAIL = "123@qq.com";

    /**
     * shiro 配置相关
     */
    public static final String ALL = "/**";
    public static final String CSS = "/css/**";
    public static final String JS = "/js/**";
    public static final String FONT = "/font/**";
    public static final String IMG = "/img/**";
    public static final String ASSETS = "/assets/**";
    public static final String UI = "/swagger-ui.html";
    public static final String WEB_JARS = "/webjars/**";
    public static final String V2 = "/v2/**";
    public static final String DRUID = "/druid/**";
    public static final String RESOURCES = "/swagger-resources/**";
    public static final String ANON = "anon";
    public static final String AUTHC = "authc";
    public static final String LEFT_SLASH = "/";
    public static final String LOGOUT_WITHOUT_SLASH = "logout";
    public static final String STR_404 = "404";
    public static final String LIFECYCLE_BEAN_POST_PROCESSOR = "lifecycleBeanPostProcessor";
    public static final String EHCACHE_SHIRO = "classpath:config/ehcache-shiro.xml";
    public static final String REMEMBER_ME = "rememberMe";
    public static final String CIPHER_KEY = "wGiHplamyXlVB11UXWol8g==";

    /**
     * druid 配置相关
     */
    public static final String PROTOTYPE = "prototype";
    public static final String MONITORING_PATH = "com.example.springboot.repository.*";
    public static final String EXCLUSIONS_NAME = "exclusions";
    public static final String EXCLUSIONS_VALUE = "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*";
    public static final String SLASH_WITH_STAR = "/*";
    public static final String DRUID_URL_MAPPINGS = "/druid/*";
    public static final String LOGIN_USER_NAME = "loginUsername";
    public static final String LOGIN_PASS_WORD = "loginPassword";
    public static final String ADMIN = "admin";
    public static final String RESET_ENABLE = "resetEnable";


    /**
     * 权限标识
     */
    public static final String PERMISSION_MENU_ADD = "menu:add";
    public static final String PERMISSION_MENU_MODIFY = "menu:modify";
    public static final String PERMISSION_MENU_DISABLE = "menu:disable";
    public static final String PERMISSION_MENU_VIEW = "menu:view";
    public static final String PERMISSION_MENU_ENABLE = "menu:enable";

    public static final String PERMISSION_DEPT_ADD = "dept:add";
    public static final String PERMISSION_DEPT_MODIFY = "dept:modify";
    public static final String PERMISSION_DEPT_DISABLE = "dept:disable";
    public static final String PERMISSION_DEPT_VIEW = "dept:view";
    public static final String PERMISSION_DEPT_ENABLE = "dept:enable";

    public static final String PERMISSION_ICON_ADD = "icon:add";
    public static final String PERMISSION_ICON_VIEW = "icon:view";

    public static final String PERMISSION_LOG_VIEW = "log:view";

    public static final String PERMISSION_ADD = "permission:add";
    public static final String PERMISSION_MODIFY = "permission:modify";
    public static final String PERMISSION_DISABLE = "permission:disable";
    public static final String PERMISSION_VIEW = "permission:view";
    public static final String PERMISSION_ENABLE = "permission:enable";

    public static final String PERMISSION_ROLE_ADD = "role:add";
    public static final String PERMISSION_ROLE_DISABLE = "role:disable";
    public static final String PERMISSION_ROLE_VIEW = "role:view";
    public static final String PERMISSION_ROLE_ENABLE = "role:enable";
    public static final String PERMISSION_ROLE_PERMISSION = "role:permission";
    public static final String PERMISSION_ROLE_MENU = "role:menu";

    public static final String PERMISSION_TIMELINE_ADD = "timeLine:add";
    public static final String PERMISSION_TIMELINE_VIEW = "timeLine:view";

    public static final String PERMISSION_USER_ADD = "user:add";
    public static final String PERMISSION_USER_MODIFY = "user:modify";
    public static final String PERMISSION_USER_DISABLE = "user:disable";
    public static final String PERMISSION_USER_VIEW = "user:view";
    public static final String PERMISSION_USER_ENABLE = "user:enable";
    public static final String PERMISSION_USER_KICK_OUT = "user:kickOut";

    private Constant() {
    }

}
