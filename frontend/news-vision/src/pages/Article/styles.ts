import styled from 'styled-components';

export const ArticleWrapper = styled.main`
  max-width: 1024px;
  margin: 0 auto;
  padding: 20px;
`;

export const ArticleHeader = styled.div`
  margin-bottom: 40px;
`;

export const ArticleTitle = styled.h1`
  margin: 0;
`;

export const ArticleDate = styled.span`
  display: block;
  margin-bottom: 20px;
`;

export const ArticleThumbnail = styled.div`
  height: 300px;
  background-color: #ddd;
  margin-bottom: 20px;
`;

export const ArticleContent = styled.div`
  p {
    margin-bottom: 20px;
    line-height: 1.5;
    font-size: 1.2rem;
  }
`;
