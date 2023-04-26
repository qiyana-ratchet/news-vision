import React from 'react';
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

const Article = () => {
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
            <ArticleTitle>나토, 7월 정상회의에 젤렌스키 우크라이나 대통령 초청</ArticleTitle>
            <ArticleDate>Tuesday, April 4, 2023</ArticleDate>
            <ArticleImgWrapper>
              <ArticleImg src={vNews3} alt="news image"/>
            </ArticleImgWrapper>
          </ArticleHeader>
          <ArticleContent>
            <p>
              북대서양조약기구, 나토가 오는 7월 정상회의에 볼로디미르 젤렌스키 우크라이나 대통령을 초대했습니다.
            </p>
            <p>
              옌스 스톨텐베르그 나토 사무총장은 현지시간 4일 벨기에 브뤼셀에서 나토 외교장관회의를 마치고 "강하고 독립적인 우크라이나는 유럽-대서양 지역 안정에 필수적"이라며 "젤렌스키 대통령을 7월
              리투아니아
              빌뉴스 정상회의에서 보기를 기대한다"고 말했습니다.</p>
            <p>
              앞서 당선 이후 우크라이나의 나토 가입을 추진해온 젤렌스키 대통령은 이날 트위터에 "나토가 러시아의 침공에 맞서기 위한 지역 내 유일하게 효과적인 안전 보장 체제"라고 적었습니다.
            </p>

            <p>
              북대서양조약기구, 나토가 오는 7월 정상회의에 볼로디미르 젤렌스키 우크라이나 대통령을 초대했습니다.
              옌스 스톨텐베르그 나토 사무총장은 현지시간 4일 벨기에 브뤼셀에서 나토 외교장관회의를 마치고 "강하고 독립적인 우크라이나는 유럽-대서양 지역 안정에 필수적"이라며 "젤렌스키 대통령을 7월
              리투아니아
              빌뉴스 정상회의에서 보기를 기대한다"고 말했습니다.</p>
            <p>
              앞서 당선 이후 우크라이나의 나토 가입을 추진해온 젤렌스키 대통령은 이날 트위터에 "나토가 러시아의 침공에 맞서기 위한 지역 내 유일하게 효과적인 안전 보장 체제"라고 적었습니다.
            </p>
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
          <NavBarTitle style={{marginBottom:-80}}>
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
