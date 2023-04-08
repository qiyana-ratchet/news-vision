import React from 'react';
import Header from '../../components/Header/Header';
import Footer from '../../components/Footer/Footer';
import { ArticleWrapper, ArticleHeader, ArticleTitle, ArticleDate, ArticleThumbnail, ArticleContent } from './styles';

const Article = () => {
  return (
    <>
      <Header />
      <ArticleWrapper>
        <ArticleHeader>
          <h2>News</h2>
          <ArticleTitle>나토, 7월 정상회의에 젤렌스키 우크라이나 대통령 초청</ArticleTitle>
          <ArticleDate>Tuesday, April 4, 2023</ArticleDate>
          <ArticleThumbnail />
        </ArticleHeader>
        <ArticleContent>
          <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam vestibulum eros a urna lobortis eleifend. Nullam
            euismod semper sapien at dignissim. Proin consectetur feugiat urna, vitae ultricies justo interdum in. Etiam
            consectetur ultrices eleifend. Donec lobortis laoreet odio, quis sagittis turpis molestie at. Fusce bibendum
            tristique bibendum. Donec commodo tellus vitae tortor gravida, eu pulvinar orci pharetra. Nam vel arcu
            aliquam, volutpat velit ac, posuere lectus.
          </p>
          <p>
            Sed aliquam id enim id pretium. Nunc et neque finibus, iaculis eros ac, ullamcorper purus. Sed molestie elit
            vitae velit tristique, a luctus nisl facilisis. Integer cursus sapien quis dolor vestibulum feugiat. Nulla
            feugiat ligula non dui hendrerit, vitae imperdiet eros vehicula. Donec luctus laoreet ligula a efficitur.
            Integer eget nibh ullamcorper, dictum tellus in, facilisis sapien. Suspendisse scelerisque, sapien eget
            ullamcorper maximus, augue odio dictum lectus, vel interdum elit elit euismod orci. Integer nec fringilla
            eros, non consectetur tortor.
          </p>
          <p>
            Nulla eget purus at mi faucibus elementum. Ut eget feugiat nisi, nec bibendum nulla. Donec id odio vel est
            ultrices convallis. Integer eget velit risus. Nulla aliquam nulla eget eros fermentum, vitae posuere eros
            dignissim. Nullam sed efficitur erat. Aliquam vitae lacinia lacus. Praesent pharetra consequat est quis
            sagittis. Suspendisse vitae urna scelerisque, congue tellus vel, ornare nibh.
          </p>
        </ArticleContent>
      </ArticleWrapper>
      <Footer />
    </>
  );
};

export default Article;
