import streamlit as st

def main():
    st.title("Auto-enhancement of underwater pictures using CNN")
    src = "https://deepwater-project.web.app/"
    
    # Adjust the height dynamically based on the content
    # This is a placeholder value, you may need to adjust it based on your actual content size
    content_height = 1200  # Adjust this value as needed
    st.components.v1.iframe(src, height=content_height)

if __name__ == "__main__":
    main()
