package com.example.springboot.constant;

public final class WebURIConstant {


    public static final String MENU_GET_LIST = "/menu/getMenuList";
    public static final String MENU_INDEX = "/menu/menuIndex";
    public static final String MENU_LIST = "/menu/list/{userId}";
    public static final String MENU_EDIT = "/menu/editMenu";
    public static final String MENU_ADD = "/menu/menuAdd";
    public static final String MENU_DISABLE = "/menu/disable";
    public static final String MENU_ENABLE = "/menu/enable/{menuId}";


    public static final String USER_INDEX = "/user/userIndex";
    public static final String USER_LIST = "/user/userList";
    public static final String DELETE_USER = "/user/delete";
    public static final String ENABLE_USER = "/user/enable/{id}";
    public static final String UPDATE_OR_ADD_USER = "/user/updateUser";
    public static final String GET_ROLE_LIST = "/user/getRoleList";
    public static final String REGISTER = "/user/register";
    public static final String RESET_PASS_WORD = "/user/reset/password";


    public static final String ROLE_INDEX = "/role/roleIndex";
    public static final String ROLE_LIST = "/role/getRoleList";
    public static final String ADD_ROLE = "/role/addRole";
    public static final String DISABLE_ROLE = "/role/disable";
    public static final String ENABLE_ROLE = "/role/enable/{roleId}";
    public static final String DEPLOY_MENU = "/role/deployMenu/{roleId}";
    public static final String GET_MENU_BY_ROLE_ID = "/role/getMenuListByRoleId/{roleId}";
    public static final String GET_PERMISSION_BY_ROLE_ID = "/role/getPermission/{roleId}";
    public static final String PERMISSION_LIST = "/role/permission/list";
    public static final String ROLE_PERMISSION_ADD = "/role/permission/add/{roleId}";


    public static final String LOGIN = "/login";
    public static final String MAP_INDEX = "/map/index";
    public static final String MAIN = "/main";
    public static final String INDEX = "/index";
    public static final String LOGOUT = "/logout";
    public static final String IMAGE_INDEX = "/image/index";


    public static final String DEPT_INDEX = "/dept/deptIndex";
    public static final String DEPT_LIST = "/dept/deptList";
    public static final String ADD_OR_UPDATE = "/dept/addOrUpdateDept";
    public static final String DISABLE_DEPT = "/dept/disable";
    public static final String ENABLE_DEPT = "/dept/enable/{deptId}";


    public static final String ICON_INDEX = "/icon/iconIndex";
    public static final String ICON_LIST = "/icon/iconList";
    public static final String ADD_ICON = "/icon/addIcon";


    public static final String TIMELINE_INDEX = "/timeLine/timeLineIndex";
    public static final String TIMELINE_LIST = "/timeLine/timeLineList";


    public static final String PERMISSION_INDEX = "/permission/permissionIndex";
    public static final String GET_PERMISSION_LIST = "/permission/getPermissionList";
    public static final String ENABLE_PERMISSION = "/permission/enable/{permissionId}";
    public static final String DISABLE_PERMISSION = "/permission/disable";
    public static final String PERMISSION_ADD_OR_UPDATE = "/permission/addOrUpdate";
    public static final String PERMISSION_PARENT = "/permission/parent";


    public static final String LOG_INDEX = "/system/logIndex";
    public static final String LOG_LIST = "/system/logList";


    public static final String ONLINE_INDEX = "/online/index";
    public static final String ONLINE_LIST = "/online/list";
    public static final String ONLINE_FORCE_LOGOUT = "/online/forceLogout/{id}";

    private WebURIConstant() {
    }
}
