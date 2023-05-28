package com.ruoyi.im.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.im.domain.UserInfo;
import com.ruoyi.im.service.IUserInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 个人信息Controller
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/manage/info")
public class UserInfoController extends BaseController
{
    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 查询个人信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserInfo userInfo)
    {
        startPage();
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        return getDataTable(list);
    }

    /**
     * 导出个人信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:info:export')")
    @Log(title = "个人信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserInfo userInfo)
    {
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        ExcelUtil<UserInfo> util = new ExcelUtil<UserInfo>(UserInfo.class);
        util.exportExcel(response, list, "个人信息数据");
    }

    /**
     * 获取个人信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:info:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return success(userInfoService.selectUserInfoByUserId(userId));
    }

    /**
     * 新增个人信息
     */
    @PreAuthorize("@ss.hasPermi('manage:info:add')")
    @Log(title = "个人信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserInfo userInfo)
    {
        return toAjax(userInfoService.insertUserInfo(userInfo));
    }

    /**
     * 修改个人信息
     */
    @PreAuthorize("@ss.hasPermi('manage:info:edit')")
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserInfo userInfo)
    {
        return toAjax(userInfoService.updateUserInfo(userInfo));
    }

    /**
     * 删除个人信息
     */
    @PreAuthorize("@ss.hasPermi('manage:info:remove')")
    @Log(title = "个人信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(userInfoService.deleteUserInfoByUserIds(userIds));
    }
}
