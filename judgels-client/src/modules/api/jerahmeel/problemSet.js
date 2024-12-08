import { stringify } from 'query-string';

import { APP_CONFIG } from '../../../conf';
import { get, post } from '../http';

export const ProblemSetErrors = {
  SlugAlreadyExists: 'Jerahmeel:ProblemSetSlugAlreadyExists',
  ArchiveSlugNotFound: 'Jerahmeel:ArchiveSlugNotFound',
  ContestSlugsNotAllowed: 'Jerahmeel:ContestSlugsNotAllowed',
};

export const baseProblemSetsURL = `${APP_CONFIG.apiUrl}/problemsets`;

export function baseProblemSetURL(problemSetJid) {
  return `${baseProblemSetsURL}/${problemSetJid}`;
}

export const problemSetAPI = {
  createProblemSet: (token, data) => {
    return post(baseProblemSetsURL, token, data);
  },

  updateProblemSet: (token, problemSetJid, data) => {
    return post(`${baseProblemSetURL(problemSetJid)}`, token, data);
  },

  getProblemSets: (token, archiveSlug, name, page) => {
    const params = stringify({ archiveSlug, name, page });
    return get(`${baseProblemSetsURL}?${params}`, token);
  },

  getProblemSetBySlug: problemSetSlug => {
    return get(`${baseProblemSetsURL}/slug/${problemSetSlug}`);
  },

  searchProblemSet: contestJid => {
    const params = stringify({ contestJid });
    return get(`${baseProblemSetsURL}/search?${params}`);
  },
};
