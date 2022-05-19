import React, { useEffect, useState } from "react";
import api from "./services/api";
import { Post } from '../src/types/post'

function App() {

  const [post, setPost] = useState<Post>();

  useEffect(() => {
    api
      .get("/posts")
      .then((response) => setPost(response.data))
      .catch((err) => {
        console.error("ops! ocorreu um erro" + err);
      });
  }, []);


  return (
<div>
<div className="App">
      <p>Usuário: {post?.autor}</p>
      <p>Biografia: {post?.id}</p>
    </div>
</div>

  );
}

export default App;
