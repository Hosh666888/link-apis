package pro.goforit.mapper;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.goforit.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author zjj20
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-08-08 16:28:15
* @Entity pro.goforit.domain.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

}




