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
import com.ruoyi.im.domain.UserSetting;
import com.ruoyi.im.service.IUserSettingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户个性化设置Controller
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/im/setting")
public class UserSettingController extends BaseController
{
    @Autowired
    private IUserSettingService userSettingService;

    /**
     * 查询用户个性化设置列表
     */
    @PreAuthorize("@ss.hasPermi('im:setting:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserSetting userSetting)
    {
        startPage();
        List<UserSetting> list = userSettingService.selectUserSettingList(userSetting);
        return getDataTable(list);
    }

    /**
     * 导出用户个性化设置列表
     */
    @PreAuthorize("@ss.hasPermi('im:setting:export')")
    @Log(title = "用户个性化设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserSetting userSetting)
    {
        List<UserSetting> list = userSettingService.selectUserSettingList(userSetting);
        ExcelUtil<UserSetting> util = new ExcelUtil<UserSetting>(UserSetting.class);
        util.exportExcel(response, list, "用户个性化设置数据");
    }

    /**
     * 获取用户个性化设置详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:setting:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userSettingService.selectUserSettingById(id));
    }

    /**
     * 新增用户个性化设置
     */
    @PreAuthorize("@ss.hasPermi('im:setting:add')")
    @Log(title = "用户个性化设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserSetting userSetting)
    {
        return toAjax(userSettingService.insertUserSetting(userSetting));
    }

    /**
     * 修改用户个性化设置
     */
    @PreAuthorize("@ss.hasPermi('im:setting:edit')")
    @Log(title = "用户个性化设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserSetting userSetting)
    {
        return toAjax(userSettingService.updateUserSetting(userSetting));
    }

    /**
     * 删除用户个性化设置
     */
    @PreAuthorize("@ss.hasPermi('im:setting:remove')")
    @Log(title = "用户个性化设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userSettingService.deleteUserSettingByIds(ids));
    }
}
