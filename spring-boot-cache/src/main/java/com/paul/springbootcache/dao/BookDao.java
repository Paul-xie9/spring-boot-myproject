package com.paul.springbootcache.dao;

import com.paul.springbootcache.model.Book;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @Author Paul.x
 * @Date 2022/8/19 1:59
 * @Description
 */
@Log4j2
@Repository
@CacheConfig(cacheNames = "book_cache")
public class BookDao {
    /**
     * @Cacheable注解表示对该方法进行缓存，默认情况下，缓存的key是方法的参数，
     * 缓存的value是方法的返回值。当开发者在其他类中调用该方法时，首先会根据调用参数查看缓存中是否有相关数据，
     * 若有，则直接使用缓存数据，该方法不会执行，否则执行该方法，执行成功后将返回值缓存起来，但若是在当前类中调用该方法，则缓存不会生效。
     * @param id
     * @return
     */
    @Cacheable
    public Book getBookById(Long id){
        Book book = new Book(id,"xiyouji","wuchengen");
        log.info("=========BookDao.getBookById===========");
        return book;
    }

    /**
     * @CachePut注解一般用于数据更新方法;
     * 与@Cacheable注解不同，添加了@CachePut注解的方法每次在执行时都不去检查缓存中是否有数据，
     * 而是直接执行方法，然后将方法的执行结果缓存起来，如果该key对应的数据已经被缓存起来了，
     * 就会覆盖之前的数据，这样可以避免再次加载数据时获取到脏数据
     * @param book
     * @return
     */
    @CachePut
    public Book updateBook(Book book){
        log.info("=========BookDao.updateBook===========");
        return book;
    }

    /**
     * @CacheEvict注解一般用于删除方法上，表示移除一个key对应的缓存。@CacheEvict注解有两个特殊的属性：
     * allEntries和beforeInvocation，其中allEntries表示是否将所有的缓存数据都移除，默认为false，
     * beforeInvocation表示是否在方法执行之前移除缓存中的数据，默认为false，即在方法执行之后移除缓存中的数据
     */
    @CacheEvict
    public void deleteBook(){
        log.info("=========BookDao.deleteBook===========");
    }
}
