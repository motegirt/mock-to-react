import { Routes, Route } from "react-router-dom";

import ProductDetailPage from "./pages/ProductDetailPage";
import CartPage from "./pages/CartPage";

function App() {
  return (
    <Routes>
      {/* <Route path="/products/:productId" element={<ProductDetailPage />} /> */}
      <Route path="/productDetail/*" element={<ProductDetailPage />} />
      <Route path="/cart" element={<CartPage />} />
    </Routes>
  );
}

export default App;