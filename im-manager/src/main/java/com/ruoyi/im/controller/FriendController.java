package com.ruoyi.im.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.im.service.service.IFriendService;
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
import com.ruoyi.im.domain.Friend;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 好友管理Controller
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/im/friend")
public class FriendController extends BaseController
{
    @Autowired
    private IFriendService friendService;

    /**
     * 查询好友管理列表
     */
    @PreAuthorize("@ss.hasPermi('im:friend:list')")
    @GetMapping("/list")
    public TableDataInfo list(Friend friend)
    {
        startPage();
        List<Friend> list = friendService.selectFriendList(friend);
        return getDataTable(list);
    }

    /**
     * 导出好友管理列表
     */
    @PreAuthorize("@ss.hasPermi('im:friend:export')")
    @Log(title = "好友管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Friend friend)
    {
        List<Friend> list = friendService.selectFriendList(friend);
        ExcelUtil<Friend> util = new ExcelUtil<Friend>(Friend.class);
        util.exportExcel(response, list, "好友管理数据");
    }

    /**
     * 获取好友管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:friend:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(friendService.selectFriendById(id));
    }

    /**
     * 新增好友管理
     */
    @PreAuthorize("@ss.hasPermi('im:friend:add')")
    @Log(title = "好友管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Friend friend)
    {
        return toAjax(friendService.insertFriend(friend));
    }

    /**
     * 修改好友管理
     */
    @PreAuthorize("@ss.hasPermi('im:friend:edit')")
    @Log(title = "好友管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Friend friend)
    {
        return toAjax(friendService.updateFriend(friend));
    }

    /**
     * 删除好友管理
     */
    @PreAuthorize("@ss.hasPermi('im:friend:remove')")
    @Log(title = "好友管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(friendService.deleteFriendByIds(ids));
    }
}
