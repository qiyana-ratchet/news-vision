import styled from 'styled-components';

export const MainWrapper = styled.main`
  max-width: 1240px;
  margin: 0 auto;
  padding: 20px;
`;

export const SectionWrapper = styled.section`
  margin-top: 45px;
  margin-bottom: 50px;
`;

export const GridSectionTitle = styled.span`
  font-family: 'Montserrat', sans-serif;
  font-size: .875rem;
  font-weight: 300;
  color: #d3d3d3;
`;

export const SectionTitle = styled.span`
  font-family: 'Montserrat', sans-serif;
  font-size: 1.375rem;
  font-weight: 600;
  color: #4A4A4A;
`;

export const BannerWrapper = styled.div`
  width: 1240px;
  height: 380px;
  margin-top: 15px;
  display: flex;
`;

export const LeftHalf = styled.div`
  width: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  //background-color: #ddd;
  padding: 0px 0px;
  position: relative;
`;

export const RightHalf = styled.div`
  width: 50%;
  height: 380px;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-template-rows: repeat(2, 1fr);
  grid-gap: 10px 10px;
  padding: 0px 10px;
  //background-color: #ddd;
`;

export const ButtonTitle = styled.div`
  width: 95%;
  letter-spacing: 0.01em;
  font-family:'BBC Reith Sans';
  font-size: 2rem;
  line-height: 1.2;
  font-weight: 100;
  color: white;
  text-align: left;
`;

export const BigButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  font-size: 1.5rem;
  object-fit: contain;
  padding: 0px;
  border: none;
  background-color: #fff;
  cursor: pointer;

  &:hover {
    opacity: 0.9;
  }

  // &:hover ${ButtonTitle} {
  //   text-decoration: underline;
  //   text-decoration-thickness: 2px;
  // }
`;

export const GridButtonTitle = styled.div`
  width: 95%;
  letter-spacing: 0.01em;
  font-family: 'BBKK';
  font-size: 1.25rem;
  line-height: 1.2;
  font-weight: 500;
  color: white;
  text-align: left;
`;

export const GridButton = styled.div`
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  font-size: 1.5rem;
  object-fit: cover;
  border: none;
  background-color: #fff;
  cursor: pointer;

  &:hover {
    opacity: 0.9;
  }
  
  // &:hover ${GridButtonTitle} {
  //   text-decoration: underline;
  //   text-decoration-thickness: 1px;
  // }
`;

export const GridDescSection = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  z-index: 2;
  height: 60%;
  width: 100%;
  top: 40%;
  background-image: linear-gradient(rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.8));
  color: white;
  position: absolute;
  align-items: center;
  text-align: left;
  font-size: 2rem;
`;

export const DescSection = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  z-index: 2;
  height: 60%;
  width: 100%;
  top: 40%;
  background-image: linear-gradient(rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.8));
  color: white;
  position: absolute;
  align-items: center;
  text-align: left;
  font-size: 2rem;
`;

export const ButtonSummary = styled.div`
  width: 95%;
  color: #d3d3d3;;
  text-align: left;
  font-size: 1rem;
  margin-top: 0.5rem;
  letter-spacing: 0.01em;
  font-family: 'ReithSansLt', Arial, Helvetica, sans-serif;
  line-height: 1.2;
  margin-bottom: 30px;
`;

export const GridTitleContainer = styled.div`
  width: 95%;
  flex-direction: row;
  align-items: flex-start;
  margin-bottom: 10px;
  margin-top: -5px;
`;

export const GridImgLeft = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

export const GridImg = styled.img`
  width: 100%;
  height: 184px;
  object-fit: cover;
`;

export const NewsWrapper = styled.div`
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
  margin-top: 15px;
`;

export const NewsThumbnail = styled.img`
  width: 100%;
  height: 225px;
  object-fit: cover;
  background-color: #ddd;
  cursor: pointer;

  &:hover {
    opacity: 0.9;
  }
`;

export const NewsTitle = styled.h3`
  margin-top: 8px;
  letter-spacing: 0.01em;
  font-family: 'ReithSans', Arial, Helvetica, sans-serif;
  font-size: 1.25rem;
  font-weight: bold;
  line-height: 1.2;
  color: #212121;
`;

export const NewsItem = styled.div`
  border-radius: 1px;
  overflow: hidden;
  &:hover ${NewsTitle} {
    text-decoration: underline;
  }
`;

export const NewsSummary = styled.h3`
  font-size: 1rem;
  margin-top: 0.5rem;
  letter-spacing: 0.01em;
  font-family: 'ReithSans', Arial, Helvetica, sans-serif;
  line-height: 1.2;
  color: #4a4a4a;
`;

export const TopStoriesWrapper = styled.div`
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 20px;
`;

export const TopStoriesItem = styled.div`
  height: 150px;
  background-color: #ddd;
`;
