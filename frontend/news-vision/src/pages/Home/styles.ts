import styled from 'styled-components';

export const MainWrapper = styled.main`
  max-width: 1240px;
  margin: 0 auto;
  padding: 20px;
`;

export const SectionWrapper = styled.section`
  margin-bottom: 40px;
`;

export const SectionTitle = styled.div`
  font-family: 'Montserrat', sans-serif;
  font-size: 1.375rem;
  font-weight: 600;
  color: #4A4A4A;
  margin-top: 40px;
`;

export const BannerWrapper = styled.div`
  width: 1240px;
  height: 380px;
  margin-top: 20px;
  display: flex;
`;

export const LeftHalf = styled.div`
  width: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  //background-color: #ddd;
  padding: 0px 8px;
`;

export const BigButton = styled.button`
  width: 100%;
  height: 100%;
  font-size: 1.5rem;
  padding: 0px;
  border: none;
  //background-color: #ffd9e1;
  //border: 2px solid #000;
`;

export const RightHalf = styled.div`
  width: 50%;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-template-rows: repeat(2, 1fr);
  grid-gap: 5px 10px;
  padding: 0px 8px;
  //background-color: #ddd;
`;

export const GridButton = styled.button`
  width: 100%;
  height: 100%;
  padding: 3px;
  border: none;
  background-color: #fff;
`;

export const GridImg = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
`;


export const NewsWrapper = styled.div`
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
`;

export const NewsItem = styled.div`
  border: 1px solid #ddd;
  border-radius: 5px;
  overflow: hidden;
`;

export const NewsThumbnail = styled.div`
  height: 200px;
  background-color: #ddd;
`;

export const NewsTitle = styled.h3`
  margin: 0;
  padding: 10px;
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
