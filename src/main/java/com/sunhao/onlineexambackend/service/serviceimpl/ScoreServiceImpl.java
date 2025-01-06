package com.sunhao.onlineexambackend.service.serviceimpl;

import com.sunhao.onlineexambackend.entity.po.Score;
import com.sunhao.onlineexambackend.mapper.ScoreMapper;
import com.sunhao.onlineexambackend.service.IScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 成绩表 服务实现类
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {

}
