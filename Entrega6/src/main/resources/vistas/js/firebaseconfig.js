import { initializeApp } from 'https://www.gstatic.com/firebasejs/10.7.0/firebase-app.js'
import { getAuth } from 'https://www.gstatic.com/firebasejs/10.7.0/firebase-auth.js'
import { getAnalytics } from 'https://www.gstatic.com/firebasejs/10.7.0/firebase-analytics.js'

// Your web app's Firebase configuration
const firebaseConfig = {
    apiKey: "AIzaSyAXR_kM0CrviHzMk3LZup_95bZ31WEqqkk",
    authDomain: "sacmore-31be7.firebaseapp.com",
    projectId: "sacmore-31be7",
    storageBucket: "sacmore-31be7.appspot.com",
    messagingSenderId: "835546982900",
    appId: "1:835546982900:web:fd722cb77ea51d75aef1a1",
    measurementId: "G-P248PS7VJT"
};

// Initialize Firebase
export const app = initializeApp(firebaseConfig);
export const auth = getAuth(app);
const analytics = getAnalytics(app);