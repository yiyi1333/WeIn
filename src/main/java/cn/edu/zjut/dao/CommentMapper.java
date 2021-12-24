package cn.edu.zjut.dao;

import org.apache.ibatis.annotations.Param;
import cn.edu.zjut.po.Comment;
import java.util.List;

public interface CommentMapper {
    public Integer addComment(@Param("consumerId")Integer consumerId, @Param("goodsId")Integer goodsId,
                              @Param("message") String message, @Param("rate") Integer rate,
                              @Param("image") String image, @Param("state") Integer state, @Param("orderId") Integer orderId);


public interface CommentMapper {
    public List<Comment> getAllCommentWithoutReview();

    public void commentNotPass(int id);

    public void commentPass(int id);

    public Comment getCommentById(int id);

    public List<Comment> getCommentByGoodId(int id);
}
