import { combineReducers } from 'redux';
import { persistReducer } from 'redux-persist';
import storage from 'redux-persist/es/storage';

import contestReducer from '../../routes/contests/contests/modules/contestReducer';
import contestWebConfigReducer from '../../routes/contests/contests/modules/contestWebConfigReducer';

export default combineReducers({
  contest: persistReducer({ key: 'urielContest', storage }, contestReducer),
  contestWebConfig: contestWebConfigReducer,
});
