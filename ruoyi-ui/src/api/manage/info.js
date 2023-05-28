import request from '@/utils/request'

// 查询个人信息列表
export function listInfo(query) {
  return request({
    url: '/manage/info/list',
    method: 'get',
    params: query
  })
}

// 查询个人信息详细
export function getInfo(userId) {
  return request({
    url: '/manage/info/' + userId,
    method: 'get'
  })
}

// 新增个人信息
export function addInfo(data) {
  return request({
    url: '/manage/info',
    method: 'post',
    data: data
  })
}

// 修改个人信息
export function updateInfo(data) {
  return request({
    url: '/manage/info',
    method: 'put',
    data: data
  })
}

// 删除个人信息
export function delInfo(userId) {
  return request({
    url: '/manage/info/' + userId,
    method: 'delete'
  })
}
