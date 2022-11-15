package com.zyy.blog.service;

import com.zyy.blog.dto.PhotoAlbumBackDTO;
import com.zyy.blog.dto.PhotoAlbumDTO;
import com.zyy.blog.entity.PhotoAlbum;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyy.blog.vo.ConditionVO;
import com.zyy.blog.vo.PageResult;
import com.zyy.blog.vo.PhotoAlbumVO;

import java.util.List;

/**
 * 相册服务
 *
 * @author poixao
 * @date 2022/11/01
 */
public interface PhotoAlbumService extends IService<PhotoAlbum> {

    /**
     * 保存或更新相册
     *
     * @param photoAlbumVO 相册信息
     */
    void saveOrUpdatePhotoAlbum(PhotoAlbumVO photoAlbumVO);

    /**
     * 查看后台相册列表
     *
     * @param condition 条件
     * @return {@link PageResult<PhotoAlbumBackDTO>} 相册列表
     */
    PageResult<PhotoAlbumBackDTO> listPhotoAlbumBacks(ConditionVO condition);

    /**
     * 获取后台相册列表信息
     *
     * @return {@link List<PhotoAlbumDTO>} 相册列表信息
     */
    List<PhotoAlbumDTO> listPhotoAlbumBackInfos();

    /**
     * 根据id获取相册信息
     *
     * @param albumId 相册id
     * @return {@link PhotoAlbumBackDTO} 相册信息
     */
    PhotoAlbumBackDTO getPhotoAlbumBackById(Integer albumId);

    /**
     * 根据id删除相册
     *
     * @param albumId 相册id
     */
    void deletePhotoAlbumById(Integer albumId);

    /**
     * 获取相册列表
     *
     * @return {@link List<PhotoAlbumDTO>}相册列表
     */
    List<PhotoAlbumDTO> listPhotoAlbums();

}
