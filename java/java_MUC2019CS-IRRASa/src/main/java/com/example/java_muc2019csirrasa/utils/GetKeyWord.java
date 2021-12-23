//package com.example.java_muc2019csirrasa.utils;
//
//import org.junit.Test;
//import org.lionsoul.jcseg.extractor.impl.TextRankKeyphraseExtractor;
//import org.lionsoul.jcseg.tokenizer.core.ADictionary;
//import org.lionsoul.jcseg.tokenizer.core.DictionaryFactory;
//import org.lionsoul.jcseg.tokenizer.core.ISegment;
//
//import java.io.IOException;
//import java.io.StringReader;
//import java.util.List;
//
//public class GetKeyWord {
//    @Test
//    public void test1() throws IOException {
//        //1, 创建Jcseg ISegment分词对象
//        SegmenterConfig config = new SegmenterConfig(true);
//        config.setClearStopwords(false);    //设置不过滤停止词
//        config.setAppendCJKSyn(false);      //设置关闭同义词追加
//        config.setKeepUnregWords(false);    //设置去除不识别的词条
//        config.setEnSecondSeg(false);       //关闭英文自动二次切分
//        ADictionary dic = DictionaryFactory.createSingletonDictionary(config);
//        ISegment seg = ISegment.COMPLEX.factory.create(config, dic);
//
////2, 构建TextRankKeyphraseExtractor关键短语提取器
//        TextRankKeyphraseExtractor extractor = new TextRankKeyphraseExtractor(seg);
//        extractor.setMaxIterateNum(100);        //设置pagerank算法最大迭代词库，非必须，使用默认即可
//        extractor.setWindowSize(5);             //设置textRank窗口大小，非必须，使用默认即可
//        extractor.setKeywordsNum(15);           //设置最大返回的关键词个数，默认为10
//        extractor.setMaxWordsNum(4);            //设置最大短语词长，默认为5
//
////3, 从一个输入reader输入流中获取短语
//        String str = "支持向量机广泛应用于文本挖掘，例如，基于支持向量机的文本自动分类技术研究一文中很详细的介绍支持向量机的算法细节，文本自动分类是文本挖掘技术中的一种！";
//        List<String> keyphrases = extractor.getKeyphrase(new StringReader(str));
//
////4, output:
////支持向量机, 自动分类
//    }
//}
