import request from '@/utils/request'

// 查询用户个性化设置列表
export function listSetting(query) {
  return request({
    url: '/im/setting/list',
    method: 'get',
    params: query
  })
}

// 查询用户个性化设置详细
export function getSetting(id) {
  return request({
    url: '/im/setting/' + id,
    method: 'get'
  })
}

// 新增用户个性化设置
export function addSetting(data) {
  return request({
    url: '/im/setting',
    method: 'post',
    data: data
  })
}

// 修改用户个性化设置
export function updateSetting(data) {
  return request({
    url: '/im/setting',
    method: 'put',
    data: data
  })
}

// 删除用户个性化设置
export function delSetting(id) {
  return request({
    url: '/im/setting/' + id,
    method: 'delete'
  })
}
