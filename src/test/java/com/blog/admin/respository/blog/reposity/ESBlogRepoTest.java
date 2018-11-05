package com.blog.admin.respository.blog.reposity;

import com.blog.admin.entity.es.ESBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ESBlogRepoTest {
    @Resource
    private ESBlogRepo esBlogRepo;
    @Before
    public void initRepository(){
        //清除所有数据
        esBlogRepo.deleteAll();
        esBlogRepo.save(new ESBlog("咏雪","唐诗","谢太傅寒雪日内集，与儿女讲论文义。俄而雪骤,公欣然曰：“白雪纷纷何所似？”兄子胡儿曰：“撒盐空中差可拟。”兄女曰：“未若柳絮因风起。”公大笑乐。即公大兄无奕女，左将军王凝之妻也。"));
        esBlogRepo.save(new ESBlog("将进酒","唐代：李白","君不见，黄河之水天上来，奔流到海不复回。\n" +
                "君不见，高堂明镜悲白发，朝如青丝暮成雪。\n" +
                "人生得意须尽欢，莫使金樽空对月。\n" +
                "天生我材必有用，千金散尽还复来。\n" +
                "烹羊宰牛且为乐，会须一饮三百杯。\n" +
                "岑夫子，丹丘生，将进酒，杯莫停。\n" +
                "与君歌一曲，请君为我倾耳听。(倾耳听 一作：侧耳听)\n" +
                "钟鼓馔玉不足贵，但愿长醉不复醒。(不足贵 一作：何足贵；不复醒 一作：不愿醒/不用醒)\n" +
                "古来圣贤皆寂寞，惟有饮者留其名。(古来 一作：自古；惟 通：唯)\n" +
                "陈王昔时宴平乐，斗酒十千恣欢谑。\n" +
                "主人何为言少钱，径须沽取对君酌。\n" +
                "五花马，千金裘，呼儿将出换美酒，与尔同销万古愁"));
        esBlogRepo.save(new ESBlog("同声歌","两汉：张衡","邂逅承际会，得充君后房。\n" +
                "情好新交接，恐栗若探汤。\n" +
                "不才勉自竭，贱妾职所当。\n" +
                "绸缪主中馈，奉礼助蒸尝。\n" +
                "思为苑蒻席，在下蔽匡床。\n" +
                "愿为罗衾帱，在上卫风霜。\n" +
                "洒扫清枕席，鞮芬以狄香。\n" +
                "重户结金扃，高下华灯光。\n" +
                "衣解巾粉御，列图陈枕张。\n" +
                "素女为我师，仪态盈万方。\n" +
                "众夫希所见，天老教轩皇。\n" +
                "乐莫斯夜乐，没齿焉可忘。"));
        esBlogRepo.save(new ESBlog("子夜吴歌·春歌","唐代：李白","秦地罗敷女，采桑绿水边。\n" +
                "素手青条上，红妆白日鲜。\n" +
                "蚕饥妾欲去，五马莫留连。"));
    }
    @Test
    public void findDistinctESBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        Page<ESBlog> page = esBlogRepo.findDistinctESBlogByTitleContainingOrSummaryContainingOrContentContaining("子夜吴歌", "李白", "绿水", new PageRequest(0, 20));
       for (ESBlog x: page.getContent()){
           System.out.println(x.toString());
       }
    }
}