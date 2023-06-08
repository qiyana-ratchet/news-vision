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
  SiteWrapper, StyledButton,

} from './styles';
import {SectionTitle, SectionWrapper} from "../Home/styles";
import vNews3 from "../../assets/images/image65.png";
import Feature1 from "../../assets/images/image66.png";
import Feature2 from "../../assets/images/image67.png";
import Feature3 from "../../assets/images/image68.png";
import {useLocation} from "react-router-dom";
// @ts-ignore
import video1 from "../../assets/videos/Starship(720p).mp4";
// @ts-ignore
import video2 from "../../assets/videos/iu.mp4";
// // @ts-ignore
// import video3 from "/app/video/배우_김수로,_영국_축구팀_첼시_로버스_FC_구단주_사임.mp4";
// // @ts-ignore
// import video4 from "../../../app/video/배우_김수로,_영국_축구팀_첼시_로버스_FC_구단주_사임.mp4";
// @ts-ignore
import video5 from "../../assets/videos/1064회_로또_1등_19명당첨금_각_13억5천만원.mp4";


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
  const [videoLoadingError, setVideoLoadingError] = useState(false);
  const [videoURI, setVideoURI] = useState("");
  const [videoCreating, setVideoCreating] = useState(false);


  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(
          // `http://localhost:8080/news/article?id=${location.state?.newsId}`
          // `/news/article?id=${location.state?.newsId}`
          `http://news-alb-rest-1045794844.ap-northeast-2.elb.amazonaws.com/news/article?id=${location.state?.newsId}`
        );
        const data: ArticleData = await response.json();
        setArticleData(data);
        console.log("data: ", data)
        console.log("articleData: ", articleData)
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

  const handleVideoError = (event: React.SyntheticEvent<HTMLVideoElement, Event>) => {
    const videoElement = event.currentTarget;
    console.error(`Error loading video: ${videoElement.error?.message}`);
    setVideoLoadingError(true);
  };

  // const handleCreateVideo = () => {
  //   fetch(`/news/video/${articleData?.id}`)
  //     .then(response => response.json())
  //     .then(data => {
  //       console.log("data: ", data);
  //       // setVideoURI(data.URI);
  //       // console.log("data.URI: ", data.URI);
  //     })
  //     .catch(error => {
  //       console.error(error);
  //     });
  // };

  // const handleCreateVideo = async () => {
  //   fetch(`/news/video/${articleData?.id}`)
  //     .then(response => {
  //       if (!response.ok) {
  //         throw new Error('Failed to fetch video');
  //       }
  //       return response.blob();
  //     })
  //     .then(blobData => {
  //       // 영상 데이터를 처리하는 로직 작성
  //       console.log('Video data:', blobData);
  //       setVideoURI(URL.createObjectURL(blobData));
  //       console.log(videoURI)
  //     })
  //     .catch(error => {
  //       console.error('Error fetching video:', error);
  //     });
  // };
  const handleCreateVideo = async () => {
    setVideoCreating(true);
    console.log('Fetching video...');
    // fetch(`/news/video/${articleData?.id}`, { mode: 'cors' })
    fetch(`http://news-alb-rest-1045794844.ap-northeast-2.elb.amazonaws.com/news/video/${articleData?.id}`, { mode: 'cors' })
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to fetch video');
        }
        console.log('Video response:', response);
        console.log('CORS headers:', response.headers.get('Access-Control-Allow-Origin'));
        return response.blob();
      })
      .then(blobData => {
        console.log('Video blob data:', blobData);
        const blobURL = URL.createObjectURL(blobData);
        console.log('Blob URL:', blobURL);
        setVideoURI(blobURL);
        console.log('Video URL set:', videoURI);
      })
      .catch(error => {
        console.error('Error fetching video:', error);
      });
  };

  console.log('Browser compatibility:', !!document.createElement('video').canPlayType);

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
              {/*<ArticleImgWrapper>*/}
              {/*  {articleData?.videoPath && !videoLoadingError ? (*/}
              {/*    <video controls autoPlay loop muted={false} style={{width: '100%', height: '100%'}}*/}
              {/*           onCanPlay={() => console.log("Video can be played.")} onError={handleVideoError}>*/}
              {/*      /!*<source src={require(videoURI)} type="video/mp4"/>*!/*/}
              {/*      <source src={videoURI} type="video/mp4"/>*/}
              {/*      /!*<source src={video1} type="video/mp4"/>*!/*/}
              {/*      Your browser does not support the video tag.*/}
              {/*    </video>*/}
              {/*  ) : (*/}
              {/*    <>*/}
              {/*      <ArticleImg src={articleData?.thumUrl ?? vNews3} alt="news image"/>*/}
              {/*      <StyledButton onClick={handleCreateVideo}>Create Video</StyledButton>*/}
              {/*    </>*/}
              {/*  )}*/}
              {/*</ArticleImgWrapper>*/}
              {/*<ArticleImgWrapper>*/}
              {/*  {videoURI && !videoLoadingError ? (*/}
              {/*    <video controls autoPlay loop muted={true} style={{width: '100%', height: '100%'}}*/}
              {/*           onCanPlay={() => console.log("Video can be played.")} onError={handleVideoError}>*/}
              {/*      <source src={videoURI} type="video/mp4"/>*/}
              {/*      /!*<source src={video5} type="video/mp4"/>*!/*/}
              {/*      Your browser does not support the video tag.*/}
              {/*    </video>*/}
              {/*  ) : (*/}
              {/*    <>*/}
              {/*      <ArticleImg src={articleData?.thumUrl ?? vNews3} alt="news image"/>*/}
              {/*      <StyledButton onClick={handleCreateVideo}>Show Video</StyledButton>*/}
              {/*    </>*/}
              {/*  )}*/}
              {/*</ArticleImgWrapper>*/}
              <ArticleImgWrapper>
                {videoURI && !videoLoadingError ? (
                  <video controls autoPlay loop muted={true} style={{width: '100%', height: '100%'}}
                         onCanPlay={() => console.log("Video can be played.")} onError={handleVideoError}>
                    <source src={videoURI} type="video/mp4"/>
                    {/*<source src={video5} type="video/mp4"/>*/}
                    Your browser does not support the video tag.
                  </video>
                ) : (
                  <>
                    <ArticleImg src={articleData?.thumUrl ?? vNews3} alt="news image"/>
                    <StyledButton onClick={handleCreateVideo}>
                      {videoCreating ? 'Creating Video...' : 'Show Video'}
                    </StyledButton>
                  </>
                )}
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
