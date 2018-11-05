package com.blog.admin.respository.blog.reposity;

import com.blog.admin.entity.es.ESBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ESBlogRepo extends ElasticsearchRepository<ESBlog,String> {
    Page<ESBlog> findDistinctESBlogByTitleContainingOrSummaryContainingOrContentContaining(String title,String summary,String content,Pageable pageable);
}
