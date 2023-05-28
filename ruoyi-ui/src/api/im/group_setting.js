import request from '@/utils/request'

// 查询群设置列表
export function listSetting(query) {
  return request({
    url: '/group/setting/list',
    method: 'get',
    params: query
  })
}

// 查询群设置详细
export function getSetting(groupId) {
  return request({
    url: '/group/setting/' + groupId,
    method: 'get'
  })
}

// 新增群设置
export function addSetting(data) {
  return request({
    url: '/group/setting',
    method: 'post',
    data: data
  })
}

// 修改群设置
export function updateSetting(data) {
  return request({
    url: '/group/setting',
    method: 'put',
    data: data
  })
}

// 删除群设置
export function delSetting(groupId) {
  return request({
    url: '/group/setting/' + groupId,
    method: 'delete'
  })
}
