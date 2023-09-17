package generator.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import generator.domain.Task;
import generator.service.TaskService;
import generator.mapper.TaskMapper;
import org.springframework.stereotype.Service;

/**
* @author daisy
* @description 针对表【task(任务表)】的数据库操作Service实现
* @createDate 2023-09-17 16:10:32
*/
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task>
implements TaskService{

}
