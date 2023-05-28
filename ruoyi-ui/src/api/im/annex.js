import request from '@/utils/request'

// 查询笔记附件列表
export function listAnnex(query) {
  return request({
    url: '/im/annex/list',
    method: 'get',
    params: query
  })
}

// 查询笔记附件详细
export function getAnnex(id) {
  return request({
    url: '/im/annex/' + id,
    method: 'get'
  })
}

// 新增笔记附件
export function addAnnex(data) {
  return request({
    url: '/im/annex',
    method: 'post',
    data: data
  })
}

// 修改笔记附件
export function updateAnnex(data) {
  return request({
    url: '/im/annex',
    method: 'put',
    data: data
  })
}

// 删除笔记附件
export function delAnnex(id) {
  return request({
    url: '/im/annex/' + id,
    method: 'delete'
  })
}
