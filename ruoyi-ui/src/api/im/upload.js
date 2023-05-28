import request from '@/utils/request'

// 查询文件分片数据列表
export function listUpload(query) {
  return request({
    url: '/im/upload/list',
    method: 'get',
    params: query
  })
}

// 查询文件分片数据详细
export function getUpload(id) {
  return request({
    url: '/im/upload/' + id,
    method: 'get'
  })
}

// 新增文件分片数据
export function addUpload(data) {
  return request({
    url: '/im/upload',
    method: 'post',
    data: data
  })
}

// 修改文件分片数据
export function updateUpload(data) {
  return request({
    url: '/im/upload',
    method: 'put',
    data: data
  })
}

// 删除文件分片数据
export function delUpload(id) {
  return request({
    url: '/im/upload/' + id,
    method: 'delete'
  })
}
