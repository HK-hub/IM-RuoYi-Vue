import request from '@/utils/request'

// 查询好友管理列表
export function listFriend(query) {
  return request({
    url: '/im/friend/list',
    method: 'get',
    params: query
  })
}

// 查询好友管理详细
export function getFriend(id) {
  return request({
    url: '/im/friend/' + id,
    method: 'get'
  })
}

// 新增好友管理
export function addFriend(data) {
  return request({
    url: '/im/friend',
    method: 'post',
    data: data
  })
}

// 修改好友管理
export function updateFriend(data) {
  return request({
    url: '/im/friend',
    method: 'put',
    data: data
  })
}

// 删除好友管理
export function delFriend(id) {
  return request({
    url: '/im/friend/' + id,
    method: 'delete'
  })
}
