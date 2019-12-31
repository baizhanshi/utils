package com.rambo.NLP;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Dijkstra.DijkstraSegment;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.util.List;

/**
 * 分词处理 Created by baizhanshi on 2019/8/1.
 */
public class TestNLP {
    public static void main(String[] args) {
        System.out.println(HanLP.segment("你好，欢迎使用HanLP汉语处理包！"));

        //标准分词
        List<Term> termList = StandardTokenizer.segment("这个储存起来很简单，一个一维数组，每个元素是一个单链表");
        System.out.println(termList);

        //nlp分词
        System.out.println(HanLP.segment("我新造一个词叫幻想乡你能识别并标注正确词性吗？"));
        // 注意观察下面两个“希望”的词性、两个“晚霞”的词性
        System.out.println(HanLP.segment("我的希望是希望张晚霞的背影被晚霞映红"));
        //索引分词
        List<Term> termList2 = IndexTokenizer.segment("主副食品");
        for (Term term : termList2) {
            System.out.println(term + " [" + term.offset + ":" + (term.offset + term.word.length()) + "]");
        }

        //最短路径分词
        Segment nShortSegment = new NShortSegment().enableCustomDictionary(false).enablePlaceRecognize(true)
                .enableOrganizationRecognize(true);
        Segment shortestSegment = new DijkstraSegment().enableCustomDictionary(false).enablePlaceRecognize(true)
                .enableOrganizationRecognize(true);
        String[] testCase = new String[] { "今天，刘志军案的关键人物,山西女商人丁书苗在市二中院出庭受审。", "刘喜杰石国祥会见吴亚琴先进事迹报告团成员", };
        for (String sentence : testCase) {
            System.out.println("N-最短分词：" + nShortSegment.seg(sentence) + "最短路分词：" + shortestSegment.seg(sentence));
        }
    }
}
