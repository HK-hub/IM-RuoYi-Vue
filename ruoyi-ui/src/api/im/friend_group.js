import request from '@/utils/request'

// 查询好友分组列表
export function listFriend_group(query) {
  return request({
    url: '/im/friend_group/list',
    method: 'get',
    params: query
  })
}

// 查询好友分组详细
export function getFriend_group(id) {
  return request({
    url: '/im/friend_group/' + id,
    method: 'get'
  })
}

// 新增好友分组
export function addFriend_group(data) {
  return request({
    url: '/im/friend_group',
    method: 'post',
    data: data
  })
}

// 修改好友分组
export function updateFriend_group(data) {
  return request({
    url: '/im/friend_group',
    method: 'put',
    data: data
  })
}

// 删除好友分组
export function delFriend_group(id) {
  return request({
    url: '/im/friend_group/' + id,
    method: 'delete'
  })
}
