import React, {useEffect, useState} from 'react';
import Header from '../../components/Header/Header';
import Footer from '../../components/Footer/Footer';
import {
  ArticleWrapper,
  ArticleHeader,
  ArticleTitle,
  ArticleDate,
  ArticleImgWrapper,
  ArticleContent,
  ArticleImg,
  SiteContainer,
  NavBarWrapper,
  NavBarTitle,
  NavBarPost,
  NavBarFeatures,
  NavBarPostTitle,
  NavBarPostDesc,
  NavBarImg,
  NavImgWrapper,
  NavBarImgDesc,
  DescWrapper,
  SiteWrapper,

} from './styles';
import {SectionTitle, SectionWrapper} from "../Home/styles";
import vNews3 from "../../assets/images/image65.png";
import Feature1 from "../../assets/images/image66.png";
import Feature2 from "../../assets/images/image67.png";
import Feature3 from "../../assets/images/image68.png";
import {useLocation} from "react-router-dom";

interface ArticleData {
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

const Article = () => {
  const location = useLocation();
  const [articleData, setArticleData] = useState<ArticleData | null>(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/news/article?id=${location.state?.newsId}`
        );
        const data: ArticleData = await response.json();
        setArticleData(data);
      } catch (error) {
        console.error(error);
      }
    };

    fetchData();
  }, [location.state?.newsId]);

  const formatDate = (dateString: string) => {
    const options: Intl.DateTimeFormatOptions = {weekday: 'long', month: 'long', day: 'numeric', year: 'numeric'};
    const date = new Date(dateString);
    return date.toLocaleDateString('en-US', options);
  };

  return (
    <>
      <Header/>
      <SiteWrapper>
        <SiteContainer>
          <ArticleWrapper>
            <ArticleHeader>
              <SectionWrapper>
                <SectionTitle style={{color: '#6CAFFF'}}>|&nbsp;</SectionTitle>
                <SectionTitle>News</SectionTitle>
              </SectionWrapper>
              <ArticleTitle>{articleData?.title}</ArticleTitle>
              <ArticleDate>{articleData?.broadcast_date && formatDate(articleData.broadcast_date)}</ArticleDate>
              <ArticleImgWrapper>
                <ArticleImg src={articleData?.thumUrl ?? '기본 이미지 URL 또는 대체값'} alt="news image"/>
              </ArticleImgWrapper>
            </ArticleHeader>
            <ArticleContent>
              {articleData?.content && articleData.content.split('\n').map((paragraph, index) => (
                <p key={index}>{paragraph}</p>
              ))}
            </ArticleContent>
          </ArticleWrapper>

          <NavBarWrapper>
            <NavBarTitle>
              Top Stories
            </NavBarTitle>
            <NavBarPost>
              <NavBarPostTitle>
                Europe's good cop and bad cop to meet Xi Jinping
              </NavBarPostTitle>
              <NavBarPostDesc>
                13 hours ago
              </NavBarPostDesc>
            </NavBarPost>
            <NavBarPost>
              <NavBarPostTitle>
                Europe's good cop and bad cop to meet Xi Jinping
              </NavBarPostTitle>
              <NavBarPostDesc>
                13 hours ago
              </NavBarPostDesc>
            </NavBarPost>
            <NavBarPost>
              <NavBarPostTitle>
                Europe's good cop and bad cop to meet Xi Jinping
              </NavBarPostTitle>
              <NavBarPostDesc>
                13 hours ago
              </NavBarPostDesc>
            </NavBarPost>
            <div style={{height: 40}}/>
            <NavBarTitle style={{marginBottom: -80}}>
              Features
            </NavBarTitle>
            <NavBarFeatures>
              <NavImgWrapper>
                <NavBarImg src={Feature1} alt="news image"/>
                <DescWrapper>
                  <NavBarImgDesc>Ukraine rapidly expanding its 'Army of Drones'</NavBarImgDesc>
                </DescWrapper>
              </NavImgWrapper>
              <NavImgWrapper>
                <NavBarImg src={Feature2} alt="news image"/>
                <DescWrapper>
                  <NavBarImgDesc>Ukraine rapidly expanding its 'Army of Drones'</NavBarImgDesc>
                </DescWrapper>
              </NavImgWrapper>
              <NavImgWrapper>
                <NavBarImg src={Feature3} alt="news image"/>
                <DescWrapper>
                  <NavBarImgDesc>Ukraine rapidly expanding its 'Army of Drones'</NavBarImgDesc>
                </DescWrapper>
              </NavImgWrapper>

            </NavBarFeatures>
          </NavBarWrapper>
        </SiteContainer>
      </SiteWrapper>
      <Footer/>
    </>
  )
    ;
};

export default Article;
