
package com.ghonem.db.op;

import java.util.List;

/**
 *
 * @author gohnem
 * @param <T>
 */
public interface UserList <T>{
    public int insert(T t);
    public int update(T t  );
    public int delete(T t );
    public List<T> load();
    
}
