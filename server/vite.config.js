import {defineConfig} from 'vite';
import path from 'path';
import springBoot from '@wim.deblauwe/vite-plugin-spring-boot';
import react from "@vitejs/plugin-react";
import tailwindcss from '@tailwindcss/vite'

export default defineConfig({
    plugins: [
        springBoot(),
        react(),
        tailwindcss()
    ],
    root: path.join(__dirname, './src/main/resources'),
    build: {
        manifest: true,
        rollupOptions: {
            input: [
                '/static/css/application.css',
                "/static/react/ListExample.tsx"
            ]
        },
        outDir: path.join(__dirname, `./target/classes/static`),
        copyPublicDir: false,
        emptyOutDir: true
    },
    server: {
        proxy: {
            // Proxy all backend requests to Spring Boot except for static assets
            '^/(?!static|assets|@|.*\\.(js|css|png|svg|jpg|jpeg|gif|ico|woff|woff2)$)': {
                target: 'http://localhost:25580',  // Proxy to Spring Boot backend
                changeOrigin: true,
                secure: false
            }
        },
        watch: {
            ignored: ['target/**']
        }
    }
});
