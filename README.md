🖼️ Image Enhancement using OpenCV & Deep Learning
📌 Overview

The Image Enhancement Project improves the quality of digital images by applying advanced techniques such as noise reduction, sharpening, brightness/contrast adjustment, and deep learning-based super-resolution.

This project is implemented in Python with OpenCV and optional deep learning models, providing a simple interface to enhance low-quality images for research, medical imaging, photography, and computer vision applications.

✨ Features

✅ Noise Reduction – Remove unwanted distortions from images.
✅ Sharpening & Smoothing – Highlight edges or create soft effects.
✅ Brightness & Contrast Adjustment – Improve visibility in dark/overexposed images.
✅ Histogram Equalization – Enhance contrast for grayscale/color images.
✅ Super-Resolution (Optional) – Use pretrained deep learning models for upscaling.
✅ Streamlit UI (Optional) – Upload, preview, and download enhanced images.

🛠️ Tech Stack

Language: Python 3.8+

Libraries:

OpenCV

NumPy

Matplotlib

scikit-image

TensorFlow / PyTorch (for super-resolution, optional)

UI (Optional): Streamlit

📂 Project Structure
Image_Enhancement/
│── data/                 # Sample input images
│── output/               # Enhanced images
│── src/
│   ├── enhance.py        # Core enhancement functions
│   ├── filters.py        # Sharpening, denoising, smoothing
│   ├── utils.py          # Helper functions
│── app.py                # Streamlit interface
│── requirements.txt      # Dependencies
│── README.md             # Project documentation

⚡ Installation

Clone the repository:

git clone https://github.com/pavankumarmukkera/Image-Enhancement.git
cd Image-Enhancement


Create and activate a virtual environment (recommended):

python -m venv venv
source venv/bin/activate   # On Linux/Mac
venv\Scripts\activate      # On Windows


Install dependencies:

pip install -r requirements.txt

▶️ Usage
🔹 Command Line
python src/enhance.py --input data/sample.jpg --output output/result.jpg --method sharpen


Methods available:

denoise

sharpen

contrast

histogram

superres (if DL model is enabled)

🔹 Streamlit App (Optional)
streamlit run app.py


Upload an image → Apply enhancement → Download results.

📊 Example Results
Input Image	Enhanced Image

	
🎯 Applications

Medical Imaging (X-rays, MRIs)

Satellite Image Enhancement

Photography Post-processing

Document Restoration

Low-light Security Footage

🤝 Contributing

Contributions are welcome! Fork the repo, make your changes, and submit a pull request.

📜 License

This project is licensed under the MIT License.