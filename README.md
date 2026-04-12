# SISOP_Kelompok5_Tugas1
# Kelompok
<table>
    <thead>
        <tr>
            <th>Nama</th>
            <th>NIM</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Naufal Fadhil Arkani</td>
            <td>255150200111037</td>
        </tr>
        <tr>
            <td>Muhammad Reyhan Setya Ardiansyah</td>
            <td>255150207111052</td>
        </tr>
        <tr>
            <td>Bagas Zakaria</td>
            <td>255150207111064</td>
        </tr>
        <tr>
            <td>Ariq Dwi Anugrah</td>
            <td>255150207111053</td>
        </tr>
        <tr>
            <td>Raven Ravellyn Sulistyo</td>
            <td>255150207111061</td>
        </tr>
    </tbody>
</table>



# Tugas Kelompok Sistem Operasi
[span_0](start_span)Membangun Simulator Sederhana Sistem Operasi: CPU Scheduling dan Deadlock Handling[span_0](end_span)

## Deskripsi Tugas
[span_1](start_span)Program sederhana ini merupakan bentuk simulasi berbasis console/CLI yang memiliki 2 fitur utama[span_1](end_span):

### Bagian A — Simulasi CPU Scheduling
[span_2](start_span)Program dapat mensimulasikan penjadwalan proses menggunakan algoritma berikut[span_2](end_span):
* [span_3](start_span)FCFS (First Come First Serve)[span_3](end_span)
* [span_4](start_span)SJF (Shortest Job First) non-preemptive[span_4](end_span)
* [span_5](start_span)Round Robin[span_5](end_span)
* [span_6](start_span)Priority Scheduling (Opsional)[span_6](end_span)

[span_7](start_span)Setiap proses minimal menerima input berupa ID Proses, Arrival Time, Burst Time, Priority, dan Quantum[span_7](end_span). Output yang ditampilkan meliputi:
* [span_8](start_span)Urutan eksekusi proses[span_8](end_span)
* [span_9](start_span)Gantt Chart sederhana (teks)[span_9](end_span)
* [span_10](start_span)Waiting Time tiap proses[span_10](end_span)
* [span_11](start_span)Turnaround Time tiap proses[span_11](end_span)
* [span_12](start_span)Response Time tiap proses[span_12](end_span)
* [span_13](start_span)Rata-rata Waiting Time[span_13](end_span)
* [span_14](start_span)Rata-rata Turnaround Time[span_14](end_span)

### Bagian B — Simulasi Deadlock
Simulasi ini menggunakan salah satu pendekatan berikut:
* [span_15](start_span)Banker’s Algorithm: Program memeriksa apakah sistem berada pada safe state berdasarkan input matriks Allocation, Maximum, dan vektor Available[span_15](end_span). [span_16](start_span)Output berupa Need Matrix, urutan safe sequence (jika ada), dan status sistem (safe atau unsafe)[span_16](end_span).
* [span_17](start_span)Deteksi Deadlock Sederhana: Program mensimulasikan proses meminta dan melepas resource, mendeteksi deadlock, dan menampilkan proses mana yang terlibat[span_17](end_span).

## Ketentuan Minimal Program
* [span_18](start_span)Memiliki menu pilihan untuk Scheduling dan Deadlock[span_18](end_span).
* [span_19](start_span)Menerima input dari pengguna atau file sederhana[span_19](end_span).
* [span_20](start_span)Menampilkan hasil dengan rapi[span_20](end_span).
* [span_21](start_span)Terdapat validasi input dasar[span_21](end_span).
* [span_22](start_span)Source code diberi komentar secukupnya[span_22](end_span).


## Luaran yang Dikumpulkan
* [span_24](start_span)Source code lengkap yang dapat dijalankan tanpa error[span_24](end_span)
* [span_25](start_span)Laporan singkat (5–8 halaman)[span_25](end_span)
* [span_26](start_span)Video / Demo singkat (durasi 5–7 menit)[span_26](end_span)
* [span_27](start_span)Presentasi (maksimal 7 slide)[span_27](end_span)

