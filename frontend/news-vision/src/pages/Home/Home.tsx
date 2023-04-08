import React from 'react';
import Header from '../../components/Header/Header';
import Footer from '../../components/Footer/Footer';
import { MainWrapper, SectionWrapper, BannerWrapper, BannerButton, NewsWrapper, NewsItem, NewsThumbnail, NewsTitle, TopStoriesWrapper, TopStoriesItem } from './styles';

const Home = () => {
  return (
    <>
      <Header />
      <MainWrapper>
        <SectionWrapper>
          <h2>Today's Virtual News</h2>
          <BannerWrapper>
            <BannerButton>Button 1</BannerButton>
            <div>
              <BannerButton>Button 2</BannerButton>
              <div>
                <BannerButton>Button 3</BannerButton>
                <BannerButton>Button 4</BannerButton>
                <BannerButton>Button 5</BannerButton>
                <BannerButton>Button 6</BannerButton>
              </div>
            </div>
          </BannerWrapper>
        </SectionWrapper>
        <SectionWrapper>
          <h2>News</h2>
          <NewsWrapper>
            <NewsItem>
              <NewsThumbnail />
              <NewsTitle>News Title</NewsTitle>
            </NewsItem>
            <NewsItem>
              <NewsThumbnail />
              <NewsTitle>News Title</NewsTitle>
            </NewsItem>
            <NewsItem>
              <NewsThumbnail />
              <NewsTitle>News Title</NewsTitle>
            </NewsItem>
            <NewsItem>
              <NewsThumbnail />
              <NewsTitle>News Title</NewsTitle>
            </NewsItem>
            <NewsItem>
              <NewsThumbnail />
              <NewsTitle>News Title</NewsTitle>
            </NewsItem>
            <NewsItem>
              <NewsThumbnail />
              <NewsTitle>News Title</NewsTitle>
            </NewsItem>
          </NewsWrapper>
        </SectionWrapper>
        <SectionWrapper>
          <h2>Top Stories</h2>
          <TopStoriesWrapper>
            <TopStoriesItem />
            <TopStoriesItem />
            <TopStoriesItem />
            <TopStoriesItem />
          </TopStoriesWrapper>
        </SectionWrapper>
      </MainWrapper>
      <Footer />
    </>
  );
};

export default Home;
