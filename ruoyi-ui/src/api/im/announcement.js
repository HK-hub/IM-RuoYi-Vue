import request from '@/utils/request'

// 查询群公告列表
export function listAnnouncement(query) {
  return request({
    url: '/im/announcement/list',
    method: 'get',
    params: query
  })
}

// 查询群公告详细
export function getAnnouncement(id) {
  return request({
    url: '/im/announcement/' + id,
    method: 'get'
  })
}

// 新增群公告
export function addAnnouncement(data) {
  return request({
    url: '/im/announcement',
    method: 'post',
    data: data
  })
}

// 修改群公告
export function updateAnnouncement(data) {
  return request({
    url: '/im/announcement',
    method: 'put',
    data: data
  })
}

// 删除群公告
export function delAnnouncement(id) {
  return request({
    url: '/im/announcement/' + id,
    method: 'delete'
  })
}
