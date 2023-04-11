import React from 'react';
import Header from '../../components/Header/Header';
import Footer from '../../components/Footer/Footer';
import {
  MainWrapper,
  SectionWrapper,
  BannerWrapper,
  LeftHalf,
  RightHalf,
  BigButton,
  GridButton,
  NewsWrapper,
  NewsItem,
  NewsThumbnail,
  NewsTitle,
  TopStoriesWrapper,
  TopStoriesItem,
  GridImg,
  SectionTitle
} from './styles';
import vNews1 from '../../assets/images/image39.png';
import {useNavigate} from "react-router-dom";

const Home = () => {
  const navigate = useNavigate();

  function myFunction() {
    navigate('/article');
    // alert("clicked");
  }


  return (
    <>
      <Header/>
      <MainWrapper>
        <SectionWrapper>
          <SectionTitle>Today's Virtual News</SectionTitle>
          <BannerWrapper>
            <LeftHalf>
              <BigButton onClick={myFunction}><GridImg src={vNews1} alt="news image"/></BigButton>
            </LeftHalf>
            <RightHalf>
              <GridButton onClick={myFunction}><GridImg src={vNews1} alt="news image"/></GridButton>
              <GridButton onClick={myFunction}><GridImg src={vNews1} alt="news image"/></GridButton>
              <GridButton onClick={myFunction}><GridImg src={vNews1} alt="news image"/></GridButton>
              <GridButton onClick={myFunction}><GridImg src={vNews1} alt="news image"/></GridButton>
            </RightHalf>
          </BannerWrapper>
        </SectionWrapper>
        <SectionWrapper>
          <SectionTitle>| News</SectionTitle>
          <NewsWrapper>
            <NewsItem>
              <NewsThumbnail/>
              <NewsTitle>News Title</NewsTitle>
            </NewsItem>
            <NewsItem>
              <NewsThumbnail/>
              <NewsTitle>News Title</NewsTitle>
            </NewsItem>
            <NewsItem>
              <NewsThumbnail/>
              <NewsTitle>News Title</NewsTitle>
            </NewsItem>
          </NewsWrapper>
        </SectionWrapper>
        <SectionWrapper>
          <h2>Top Stories</h2>
          <TopStoriesWrapper>
            <TopStoriesItem/>
            <TopStoriesItem/>
            <TopStoriesItem/>
            <TopStoriesItem/>
          </TopStoriesWrapper>
        </SectionWrapper>
      </MainWrapper>
      <Footer/>
    </>
  );
};

export default Home;
