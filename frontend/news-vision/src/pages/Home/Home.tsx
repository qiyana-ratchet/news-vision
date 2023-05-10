import React, {useEffect, useState} from 'react';
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
  NewsSummary,
  ButtonTitle,
  ButtonSummary,
  GridImg,
  SectionTitle,
  DescSection,
  GridDescSection,
  GridButtonTitle,
  GridSectionTitle,
  GridTitleContainer, GridImgLeft,
} from './styles';

import vNews1 from '../../assets/images/image39.png';
import vNews2 from '../../assets/images/image40.png';
import vNews3 from '../../assets/images/image60.png';
import vNews4 from '../../assets/images/image61.png';
import vNews5 from '../../assets/images/image62.png';
import vNews6 from '../../assets/images/image63.png';
import vNews7 from '../../assets/images/image64.png';
import News1 from '../../assets/images/image52.png';
import News2 from '../../assets/images/image51.png';
import News3 from '../../assets/images/image53.png';
import News4 from '../../assets/images/image57.png';
import News5 from '../../assets/images/image58.png';
import News6 from '../../assets/images/image59.png';
import {useNavigate} from "react-router-dom";


interface News {
  id: number;
  title: string;
  broadcast_date: string;
  reporter: string;
  content: string | null;
  p_content: string | null;
  thumUrl: string | null;
  videoPath: string | null;
  genre: string | null;
}

interface NewsList {
  content: News[];
}

const Home = () => {
  const navigate = useNavigate();
  const [newsList, setNewsList] = useState<News[]>([]);

  useEffect(() => {
    async function fetchNewsList() {
      try {
        const response = await fetch('http://localhost:8080/news/list?page=0');
        const data: NewsList = await response.json();
        setNewsList(data.content);
        console.log("Fetched Data from API")
      } catch (error) {
        console.error(error);
      }
    }

    fetchNewsList();
  }, []);

  function myFunction() {
    navigate('/article');
    // alert("clicked");
  }

  return (
    <>
      {/*<div>*/}
      {/*  {newsList.map((news) => (*/}
      {/*    <div key={news.id}>*/}
      {/*      <h2>{news.title}</h2>*/}
      {/*      <p>{news.reporter}</p>*/}
      {/*      <p>{news.broadcast_date}</p>*/}
      {/*      {news.thumUrl && <img src={news.thumUrl} alt={news.title} />}*/}
      {/*      <p>{news.content}</p>*/}
      {/*    </div>*/}
      {/*  ))}*/}
      {/*</div>*/}
      <Header/>
      <MainWrapper>
        <SectionWrapper>
          <SectionTitle>Today's Virtual News</SectionTitle>
          <BannerWrapper>
            <LeftHalf>
              <BigButton onClick={myFunction}>
                {/*<GridImgLeft src={vNews3} alt="news image"/>*/}
                {/*<ButtonTitle>US airman to appear in court over intelligence leak</ButtonTitle>*/}
                {/*<ButtonSummary>Jack Teixeira faces charges in Boston after classified files on the war in Ukraine*/}
                {/*  appeared online.*/}
                {/*</ButtonSummary>*/}
                {newsList.length > 0 ? (newsList[0].thumUrl &&
                    <GridImgLeft src={newsList[0].thumUrl} alt={newsList[0].title}/>) :
                  <GridImgLeft src={vNews3} alt="news image"/>}
                <DescSection>
                  {newsList.length > 0 ? <ButtonTitle>{newsList[0].title}</ButtonTitle> : <div></div>}
                  {/*<ButtonSummary>2019년 할리우드에서 열린 '어벤져스:엔드게임' 출연진 핸드프린팅 행사 현장의 조핸슨</ButtonSummary>*/}
                </DescSection>
              </BigButton>
            </LeftHalf>
            <RightHalf>
              <GridButton onClick={myFunction}>
                {/*<GridImg src={vNews4} alt="news image"/>*/}
                {newsList.length > 0 ? (newsList[1].thumUrl &&
                    <GridImg src={newsList[1].thumUrl} alt={newsList[1].title}/>) :
                  <GridImg src={vNews3} alt="news image"/>}
                <DescSection>
                  {/*<GridButtonTitle>US airman to appear in court over intelligence leak</GridButtonTitle>*/}
                  {newsList.length > 0 ? <GridButtonTitle>{newsList[1].title}</GridButtonTitle> : <div></div>}
                  <GridTitleContainer>
                    <GridSectionTitle style={{color: '#6CAFFF'}}>|&nbsp;</GridSectionTitle>
                    <GridSectionTitle>News</GridSectionTitle>
                  </GridTitleContainer>
                </DescSection>
              </GridButton>
              <GridButton onClick={myFunction}>
                {/*<GridImg src={vNews5} alt="news image"/>*/}
                {newsList.length > 0 ? (newsList[2].thumUrl &&
                    <GridImg src={newsList[2].thumUrl} alt={newsList[2].title}/>) :
                  <GridImg src={vNews3} alt="news image"/>}
                <DescSection>
                  {/*<GridButtonTitle>US airman to appear in court over intelligence leak</GridButtonTitle>*/}
                  {newsList.length > 0 ? <GridButtonTitle>{newsList[2].title}</GridButtonTitle> : <div></div>}
                  <GridTitleContainer>
                    <GridSectionTitle style={{color: '#6CAFFF'}}>|&nbsp;</GridSectionTitle>
                    <GridSectionTitle>News</GridSectionTitle>
                  </GridTitleContainer>
                </DescSection>
              </GridButton>
              <GridButton onClick={myFunction}>
                {/*<GridImg src={vNews6} alt="news image"/>*/}
                {newsList.length > 0 ? (newsList[3].thumUrl &&
                    <GridImg src={newsList[3].thumUrl} alt={newsList[3].title}/>) :
                  <GridImg src={vNews3} alt="news image"/>}
                <DescSection>
                  {/*<GridButtonTitle>US airman to appear in court over intelligence leak</GridButtonTitle>*/}
                  {newsList.length > 0 ? <GridButtonTitle>{newsList[3].title}</GridButtonTitle> : <div></div>}
                  <GridTitleContainer>
                    <GridSectionTitle style={{color: '#6CAFFF'}}>|&nbsp;</GridSectionTitle>
                    <GridSectionTitle>News</GridSectionTitle>
                  </GridTitleContainer>
                </DescSection>
              </GridButton>
              <GridButton onClick={myFunction}>
                {/*<GridImg src={vNews7} alt="news image"/>*/}
                {newsList.length > 0 ? (newsList[4].thumUrl &&
                    <GridImg src={newsList[4].thumUrl} alt={newsList[4].title}/>) :
                  <GridImg src={vNews3} alt="news image"/>}
                <DescSection>
                  {/*<GridButtonTitle>US airman to appear in court over intelligence leak</GridButtonTitle>*/}
                  {newsList.length > 0 ? <GridButtonTitle>{newsList[4].title}</GridButtonTitle> : <div></div>}
                  <GridTitleContainer>
                    <GridSectionTitle style={{color: '#6CAFFF'}}>|&nbsp;</GridSectionTitle>
                    <GridSectionTitle>News</GridSectionTitle>
                  </GridTitleContainer>
                </DescSection>
              </GridButton>
            </RightHalf>
          </BannerWrapper>
        </SectionWrapper>

        <SectionWrapper>
          <SectionTitle style={{color: '#6CAFFF'}}>|&nbsp;</SectionTitle>
          <SectionTitle>News</SectionTitle>
          <NewsWrapper>
            <NewsItem>
              {/*<NewsThumbnail src={News1} alt="news image"/>*/}
              {newsList.length > 0 ? (newsList[6].thumUrl &&
                  <NewsThumbnail src={newsList[6].thumUrl} alt={newsList[6].title}/>) :
                <NewsThumbnail src={vNews3} alt="news image"/>}
              <NewsTitle>Dove or dog: China makes peace while baring its teeth</NewsTitle>
              <NewsSummary>As Beijing tries to play peacemaker, its actions over Taiwan threaten to undercut its
                goals.</NewsSummary>
            </NewsItem>
            <NewsItem>
              {/*<NewsThumbnail src={News2} alt="news image"/>*/}
              {newsList.length > 0 ? (newsList[7].thumUrl &&
                  <NewsThumbnail src={newsList[7].thumUrl} alt={newsList[7].title}/>) :
                <NewsThumbnail src={vNews3} alt="news image"/>}
              <NewsTitle>Texas dairy farm explosion kills 18,000 cows</NewsTitle>
              <NewsSummary>Animal welfare activists say the incident is "by far" the deadliest barn fire in recent
                memory.</NewsSummary>
            </NewsItem>
            <NewsItem>
              {/*<NewsThumbnail src={News3} alt="news image"/>*/}
              {newsList.length > 0 ? (newsList[1].thumUrl &&
                  <NewsThumbnail src={newsList[1].thumUrl} alt={newsList[1].title}/>) :
                <NewsThumbnail src={vNews3} alt="news image"/>}
              <NewsTitle>North Korea tests 'most powerful' missile to date</NewsTitle>
              <NewsSummary>It says the new solid-fuel intercontinental ballistic missile will improve its nuclear
                counterattack capability.</NewsSummary>
            </NewsItem>
          </NewsWrapper>
        </SectionWrapper>

        <SectionWrapper>
          <SectionTitle style={{color: '#FFD930'}}>|&nbsp;</SectionTitle>
          <SectionTitle>Sport</SectionTitle>
          <NewsWrapper>
            <NewsItem>
              <NewsThumbnail src={News4} alt="news image"/>
              <NewsTitle>Premier League build-up and news conferences</NewsTitle>
              <NewsSummary>Friday's Premier League news conferences before the weekend's action.</NewsSummary>
            </NewsItem>
            <NewsItem>
              <NewsThumbnail src={News5} alt="news image"/>
              <NewsTitle>Martinez injury does not look great - Ten Hag</NewsTitle>
              <NewsSummary>Manchester United boss Erik ten Hag says Lisandro Martinez's injury during the Europa
                League quarter-final with Sevilla "does not look that great".</NewsSummary>
            </NewsItem>
            <NewsItem>
              <NewsThumbnail src={News6} alt="news image"/>
              <NewsTitle>West Ham dig deep to secure draw away to Gent</NewsTitle>
              <NewsSummary>West Ham remain well placed to make back-to-back European semi-finals despite seeing
                their 100% winning run in the Europa Conference League ended by Gent.</NewsSummary>
            </NewsItem>
          </NewsWrapper>
        </SectionWrapper>

        {/*<SectionWrapper>*/}
        {/*  <h2>Top Stories</h2>*/}
        {/*  <TopStoriesWrapper>*/}
        {/*    <TopStoriesItem/>*/}
        {/*    <TopStoriesItem/>*/}
        {/*    <TopStoriesItem/>*/}
        {/*    <TopStoriesItem/>*/}
        {/*  </TopStoriesWrapper>*/}
        {/*</SectionWrapper>*/}

      </MainWrapper>
      <Footer/>
    </>
  );
};

export default Home;
