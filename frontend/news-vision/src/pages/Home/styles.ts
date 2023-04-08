import styled from 'styled-components';

export const MainWrapper = styled.main`
  max-width: 1024px;
  margin: 0 auto;
  padding: 20px;
`;

export const SectionWrapper = styled.section`
  margin-bottom: 40px;
`;

export const BannerWrapper = styled.div`
  display: flex;

  div:first-child {
    margin-right: 20px;
  }

  div:last-child {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    gap: 20px;

    div:first-child {
      grid-column: 1 / 2;
      grid-row: 1 / 2;
    }

    div:last-child {
      grid-column: 2 / 3;
      grid-row: 1 / 3;
    }

    button:nth-child(3) {
      grid-column: 1 / 2;
      grid-row: 2 / 3;
    }

    button:nth-child(4) {
      grid-column: 2 / 3;
      grid-row: 2 / 3;
    }

    button:nth-child(5) {
      grid-column: 1 / 2;
      grid-row: 3 / 4;
    }

    button:nth-child(6) {
      grid-column: 2 / 3;
      grid-row: 3 / 4;
    }
  }
`;

export const BannerButton = styled.button`
  padding: 10px 20px;
  background-color: #000;
  color: #fff;
  border: none;
  cursor: pointer;
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
